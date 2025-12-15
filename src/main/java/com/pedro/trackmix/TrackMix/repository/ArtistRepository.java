package com.pedro.trackmix.TrackMix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedro.trackmix.TrackMix.model.entity.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByNameContainingIgnoreCase(String name);

}
