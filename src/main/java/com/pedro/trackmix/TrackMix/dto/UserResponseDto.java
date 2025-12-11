package com.pedro.trackmix.TrackMix.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;
}
