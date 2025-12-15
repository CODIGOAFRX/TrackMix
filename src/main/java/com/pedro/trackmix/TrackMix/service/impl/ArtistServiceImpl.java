package com.pedro.trackmix.TrackMix.service.impl;

import com.pedro.trackmix.TrackMix.exception.ResourceNotFoundException;
import com.pedro.trackmix.TrackMix.model.entity.Artist;
import com.pedro.trackmix.TrackMix.repository.ArtistRepository;
import com.pedro.trackmix.TrackMix.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public Artist getById(Long id){
        return artistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
    }
    
    @Override 
    public List<Artist> getAll(){
        return artistRepository.findAll();
    }

    @Override
    public Artist create(Artist artist){
        return artistRepository.save(artist);
    }

    @Override
    public Artist update(Long id, Artist artistDetails){
        Artist artist = getById(id);
        artist.setName(artistDetails.getName());
        artist.setCountry(artistDetails.getCountry());
        artist.setMainGenre(artistDetails.getMainGenre());
        return artist;
    }
    
    @Override
    public void delete(Long id){
        Artist artist = getById(id);
        artistRepository.delete(artist);
    }
}
