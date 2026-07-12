package com.example.dto;

import com.example.models.Job;
import com.example.models.JobStatus;
import com.example.models.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private Double minimumSalary;
    private Double maximumSalary;
    private String location;
    private JobStatus jobStatus;
    private JobType jobType;
    private LocalDateTime postedDate;
    private LocalDateTime deadLine;
    private String employerCompanyName;

    public static JobResponse from(Job job){
        JobResponse response = new JobResponse();
        response.setId(job.getId());
        response.setTitle((job.getTitle()));
        response.setDescription(job.getDescription());
        response.setLocation((job.getLocation()));
        response.setMinimumSalary(job.getMinimumSalary());
        response.setMaximumSalary(job.getMaximumSalary());
        response.setJobType(job.getJobType());
        response.setJobStatus(job.getStatus());
        response.setPostedDate(job.getPostedDate());
        response.setDeadLine(job.getDeadline());
        response.setEmployerCompanyName(job.getEmployerProfile().getCompanyName());
        return response;
    }

}
