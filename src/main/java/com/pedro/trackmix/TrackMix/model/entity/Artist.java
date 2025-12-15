package com.pedro.trackmix.TrackMix.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "artists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Agrega el patrón de diseño Builder

public class Artist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(name = "main genre",length = 200)
    private String mainGenre;

    @Column(name = "created at", nullable = false)
    private String createdAt;
    
}
