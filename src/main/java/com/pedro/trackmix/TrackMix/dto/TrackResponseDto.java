package com.pedro.trackmix.TrackMix.dto;

import lombok.Data;
@Data
public class TrackResponseDto {
    private long id;
    private long artistId;
    private String title;
    private int duration;
    private String genre;
    private int year;
    private String album;
}
