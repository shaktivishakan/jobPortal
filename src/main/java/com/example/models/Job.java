package com.example.models;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employerProfile")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "employer_id")
    @ManyToOne
    private EmployerProfile employerProfile;

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns =  @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    private String title;
    private String description;

    private String location;

    private Double minimumSalary;
    private Double maximumSalary;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @CreationTimestamp
    private LocalDateTime postedDate;
    @Nullable
    private LocalDateTime deadline;

}
