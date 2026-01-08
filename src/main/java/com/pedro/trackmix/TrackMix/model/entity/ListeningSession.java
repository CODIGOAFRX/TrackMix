package com.pedro.trackmix.TrackMix.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
 

@Entity
@Table(name = "listening_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ListeningSession {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime listenedAt;

    @Column(nullable = false)
    private int durationListened;

    @Column(nullable = false)
    private boolean completed;

}
