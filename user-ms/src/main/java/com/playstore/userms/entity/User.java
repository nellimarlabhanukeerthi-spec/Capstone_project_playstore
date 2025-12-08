package com.playstore.userms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username; // can be email or username

    @Column(nullable = false)
    private String password;

    private String fullName;

    private String role = "USER"; // simple role field

    private boolean enabled = true;
}
