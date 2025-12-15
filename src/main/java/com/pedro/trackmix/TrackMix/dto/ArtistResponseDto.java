package com.pedro.trackmix.TrackMix.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArtistResponseDto {
    private Long id;
    private String name;
    private String country;
    private String mainGenre;
    private LocalDateTime createdAt;
}
