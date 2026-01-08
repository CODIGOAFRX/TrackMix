package com.pedro.trackmix.TrackMix.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Track {

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 200)
    private String title;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false , length = 200)
    private String genre ;

    @Column(nullable = false)
    private int year;

    @Column(length = 200)
    private String album;

}
