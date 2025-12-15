package com.pedro.trackmix.TrackMix.mapper;

import com.pedro.trackmix.TrackMix.dto.ArtistResponseDto;
import com.pedro.trackmix.TrackMix.dto.ArtistRequestDto;
import com.pedro.trackmix.TrackMix.model.entity.Artist;

import java.time.LocalDateTime;

// En esta clase se implementan los métodos para mapear entre Artist, ArtitsRequestDto y ArtistResponseDto

public class ArtistMapper {

    public static Artist toEntity(ArtistRequestDto dto) {
        return Artist.builder()
                .name(dto.getName())
                .country(dto.getCountry())
                .mainGenre(dto.getMainGenre())
                .createdAt(LocalDateTime.now().toString())
                .build();
    }

    public static ArtistResponseDto toDto(Artist artist) {
        ArtistResponseDto dto = new ArtistResponseDto();
        dto.setId(artist.getId());
        dto.setName(artist.getName());
        dto.setCountry(artist.getCountry());
        dto.setMainGenre(artist.getMainGenre());
        dto.setCreatedAt(LocalDateTime.parse(artist.getCreatedAt()));
        return dto;
    }

    public static void updateEntityFromDto(ArtistRequestDto dto, Artist artist) {
        artist.setName(dto.getName());
        artist.setCountry(dto.getCountry());
        artist.setMainGenre(dto.getMainGenre());
    }
}
