package com.pedro.trackmix.TrackMix.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    
}
