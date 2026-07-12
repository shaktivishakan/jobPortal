package com.example.dto;

import com.example.models.JobType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String location;

    private Double minimumSalary;
    private Double maximumSalary;

    @NotNull
    private JobType jobType;

    private LocalDateTime deadline;

    @NotNull
    private Long employerId; // placeholder until JWT auth provides this
}