package com.pedro.trackmix.TrackMix.controller;

import com.pedro.trackmix.TrackMix.dto.ArtistRequestDto;
import com.pedro.trackmix.TrackMix.dto.ArtistResponseDto;
import com.pedro.trackmix.TrackMix.mapper.ArtistMapper;
import com.pedro.trackmix.TrackMix.model.entity.Artist;
import com.pedro.trackmix.TrackMix.service.ArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/artist")
@RequiredArgsConstructor
public class ArtistController {

    ArtistService artistService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistResponseDto create (@Valid@RequestBody ArtistRequestDto requestDto){
        Artist artist = ArtistMapper.toEntity(requestDto);
        Artist saved = artistService.create(artist);
        return ArtistMapper.toDto(saved);
    }

    @GetMapping("/{id}")
    public ArtistResponseDto getById (@PathVariable Long id){
        Artist artist = artistService.getById(id);
        return ArtistMapper.toDto(artist);
    }

    @GetMapping
    public List<ArtistResponseDto> getAll(){
        return artistService.getAll()
        .stream()
        .map(ArtistMapper::toDto)
        .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ArtistResponseDto update (@PathVariable Long id, @Valid @RequestBody ArtistRequestDto requestDto){
        Artist existing = artistService.getById(id);
        ArtistMapper.updateEntityFromDto(requestDto, existing);
        Artist updated = artistService.update(id, existing);
        return ArtistMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        artistService.delete(id);
    }
}
