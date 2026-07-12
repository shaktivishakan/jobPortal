package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobapplication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "candidate_profile_id")
    private CandidateProfile candidateProfile;

    private String coverLetter;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    @CreationTimestamp
    private LocalDateTime appliedDate;
}
