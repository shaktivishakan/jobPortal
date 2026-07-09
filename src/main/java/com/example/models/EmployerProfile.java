package com.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employerprofile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class EmployerProfile {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    private String companyName;
    private String companyDescription;
    private String website;
    private String industry;
}
