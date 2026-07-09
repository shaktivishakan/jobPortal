package com.example.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="candidateprofile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "user")

public class CandidateProfile {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "candidate_skills",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns =  @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    private String phone;
    private String headline;
    private int experienceYears;
    private String resumeUrl;
    private String education;
}
