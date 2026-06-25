package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record CandidateProfileUpdateRequest(

        @Size(max = 15, message = "Phone must be at most 15 characters")
        String phone,

        @Size(max = 120, message = "Headline must be at most 120 characters")
        String headline,

        @Min(value = 0, message = "Experience years cannot be negative")
        int experienceYears,

        @Size(max = 500, message = "Resume URL must be at most 500 characters")
        String resumeUrl,

        @Size(max = 300, message = "Education must be at most 300 characters")
        String education
) {}