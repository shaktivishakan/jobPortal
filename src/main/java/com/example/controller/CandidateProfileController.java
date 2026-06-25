package com.example.controller;

import com.example.dto.CandidateProfileResponse;
import com.example.dto.CandidateProfileUpdateRequest;
import com.example.exception.DuplicateResourceException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.CandidateProfile;
import com.example.model.User;
import com.example.repository.CandidateProfileRepository;
import com.example.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidateProfileController {

    private final CandidateProfileRepository candidateProfileRepository;
    private final UserRepository userRepository;

    public CandidateProfileController(CandidateProfileRepository candidateProfileRepository,
                                      UserRepository userRepository) {
        this.candidateProfileRepository = candidateProfileRepository;
        this.userRepository = userRepository;
    }

    // GET /api/candidates
    @GetMapping
    public ResponseEntity<List<CandidateProfileResponse>> getAllCandidates() {
        List<CandidateProfileResponse> profiles = candidateProfileRepository.findAll()
                .stream()
                .map(CandidateProfileResponse::from)
                .toList();
        return ResponseEntity.ok(profiles);
    }

    // GET /api/candidates/1
    @GetMapping("/{id}")
    public ResponseEntity<CandidateProfileResponse> getCandidateById(@PathVariable Long id) {
        Optional<CandidateProfile> candidateOpt = candidateProfileRepository.findById(id);
        if (candidateOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CandidateProfileResponse.from(candidateOpt.get()));
    }

    // POST /api/candidates/1  ← userId comes from the URL, no request body needed
    @PostMapping("/{userId}")
    public ResponseEntity<CandidateProfileResponse> createCandidateProfile(@PathVariable Long userId) {

        // Step 1: does this user exist at all?
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }

        // Step 2: does this user already have a profile?
        if (candidateProfileRepository.existsById(userId)) {
            throw new DuplicateResourceException("Candidate profile already exists for user: " + userId);
        }

        // Step 3: safe to create now
        CandidateProfile profile = new CandidateProfile();
        profile.setUser(userOpt.get());  // @MapsId derives profile's id from user's id

        CandidateProfile saved = candidateProfileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(CandidateProfileResponse.from(saved));
    }

    // PUT /api/candidates/1
    @PutMapping("/{id}")
    public ResponseEntity<CandidateProfileResponse> updateCandidate(
            @PathVariable Long id,
            @Valid @RequestBody CandidateProfileUpdateRequest request) {

        Optional<CandidateProfile> candidateOpt = candidateProfileRepository.findById(id);
        if (candidateOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CandidateProfile profile = candidateOpt.get();
        if (request.phone() != null)     profile.setPhone(request.phone());
        if (request.headline() != null)  profile.setHeadline(request.headline());
        if (request.resumeUrl() != null) profile.setResumeUrl(request.resumeUrl());
        if (request.education() != null) profile.setEducation(request.education());
        profile.setExperienceYears(request.experienceYears());

        CandidateProfile saved = candidateProfileRepository.save(profile);
        return ResponseEntity.ok(CandidateProfileResponse.from(saved));
    }

    // DELETE /api/candidates/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        if (!candidateProfileRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        candidateProfileRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}