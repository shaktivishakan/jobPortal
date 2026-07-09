package com.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "saved_jobs")
@Getter
@Setter
@NoArgsConstructor
public class SavedJob {

    @EmbeddedId
    private SavedJobId id;              // the two-number ticket (candidateId + jobId)

    @ManyToOne
    @MapsId("candidateId")              // reuse candidateId from the ticket
    @JoinColumn(name = "candidate_id")
    private CandidateProfile candidateProfile;

    @ManyToOne
    @MapsId("jobId")                    // reuse jobId from the ticket
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDateTime savedAt;      // the extra column job_skills didn't have
}