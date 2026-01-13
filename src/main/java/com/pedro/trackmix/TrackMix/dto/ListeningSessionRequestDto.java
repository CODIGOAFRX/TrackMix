package com.pedro.trackmix.TrackMix.dto;

import java.time.LocalDateTime;
import lombok.Data;
@Data
public class ListeningSessionRequestDto {
    private LocalDateTime listenedAt;
    private int durationListened;
    private boolean completed;
}
