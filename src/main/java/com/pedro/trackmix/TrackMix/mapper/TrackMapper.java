package com.pedro.trackmix.TrackMix.mapper;

import com.pedro.trackmix.TrackMix.dto.TrackRequestDto;
import com.pedro.trackmix.TrackMix.dto.TrackResponseDto;
import com.pedro.trackmix.TrackMix.model.entity.Track;

public class TrackMapper {

    public static Track toEntity(TrackRequestDto dto){
        return Track.builder()
        .title(dto.getTitle())
        .duration(dto.getDuration())
        .genre(dto.getGenre())
        .year(dto.getYear())
        .album(dto.getAlbum())
        .build();
    }

    public static TrackResponseDto toDto(Track track){
        TrackResponseDto dto = new TrackResponseDto();
        dto.setId(track.getId());
        dto.setArtistId(track.getArtist().getId());
        dto.setTitle(track.getTitle());
        dto.setDuration(track.getDuration());
        dto.setGenre(track.getGenre());
        dto.setYear(track.getYear());
        dto.setAlbum(track.getAlbum());
        return dto;
        }
    
    public static void updateEntityFromDto(TrackRequestDto dto,Track track) {
        track.setTitle(dto.getTitle());
        track.setDuration(dto.getDuration());
        track.setGenre(dto.getGenre());
        track.setYear(dto.getYear());
        track.setAlbum(dto.getAlbum());
    }
}
