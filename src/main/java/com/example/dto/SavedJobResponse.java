package com.example.dto;

import com.example.models.SavedJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavedJobResponse {
    private Long candidateId;
    private JobResponse job;
    private LocalDateTime savedAt;

    public static SavedJobResponse from(SavedJob savedJob) {
        SavedJobResponse response = new SavedJobResponse();
        response.setCandidateId(savedJob.getCandidateProfile().getId());
        response.setJob(JobResponse.from(savedJob.getJob()));
        response.setSavedAt(savedJob.getSavedAt());
        return response;
    }
}