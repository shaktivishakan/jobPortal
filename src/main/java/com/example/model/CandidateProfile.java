package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="candidateprofile")
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CandidateProfile {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String phone;
    private String headline;
    private int experienceYears;
    private String resumeUrl;
    private String education;
}
