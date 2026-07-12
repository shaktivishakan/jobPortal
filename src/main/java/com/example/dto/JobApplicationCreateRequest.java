package com.example.dto;

import com.example.models.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationCreateRequest {
    @NotBlank
    private Long jobId;

    @NotBlank
    private String coverLetter;

    @NotNull
    private Long candidateId;


}
