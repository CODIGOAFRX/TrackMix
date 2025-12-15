package com.pedro.trackmix.TrackMix.service;

import com.pedro.trackmix.TrackMix.model.entity.Artist;

import java.util.List;

public interface ArtistService {

    Artist getById(Long id);

    List<Artist> getAll();

    Artist create(Artist artist);

    Artist update(Long id, Artist artist);

    void delete(Long id);

}
