package com.example.dto;

import com.example.model.CandidateProfile;

public record CandidateProfileResponse(
        Long id,
        String fullName,
        String email,
        String phone,
        String headline,
        int experienceYears,
        String resumeUrl,
        String education
) {
    public static CandidateProfileResponse from(CandidateProfile profile) {
        return new CandidateProfileResponse(
                profile.getId(),
                profile.getUser().getName(),
                profile.getUser().getEmail(),
                profile.getPhone(),
                profile.getHeadline(),
                profile.getExperienceYears(),
                profile.getResumeUrl(),
                profile.getEducation()
        );
    }
}