package com.playstore.appms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;
    private String name;
    private String description;
    private String version;
    private LocalDate releaseDate;

    private double rating;
    private int downloads;

    private String category;

    private boolean visible = true;
}
