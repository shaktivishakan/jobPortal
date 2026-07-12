package com.example.dto;

import com.example.models.ApplicationStatus;
import com.example.models.JobApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationResponse {
    private Long id;
    private Long jobId;
    private Long candidateId;
    private String coverLetter;
    private ApplicationStatus status;
    private LocalDateTime appliedDate;

    public static JobApplicationResponse from(JobApplication jobApplication) {
        JobApplicationResponse response = new JobApplicationResponse();
        response.setId(jobApplication.getId());
        response.setJobId(jobApplication.getJob().getId());
        response.setCandidateId(jobApplication.getCandidateProfile().getId());
        response.setCoverLetter(jobApplication.getCoverLetter());
        response.setStatus(jobApplication.getStatus());
        response.setAppliedDate(jobApplication.getAppliedDate());
        return response;
    }
}