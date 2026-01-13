package com.pedro.trackmix.TrackMix.dto;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ListeningSessionResponseDto {
    private long id;
    private long userId;
    private long trackId;
    private LocalDateTime listenedAt;
    private int durationListened;
    private boolean completed;
}
