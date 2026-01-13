package com.pedro.trackmix.TrackMix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedro.trackmix.TrackMix.model.entity.Track; 
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByTitleContainingIgnoreCase(String title);

    List<Track> findByArtistId(Long artistId);   // = track.artist.id

    List<Track> findByGenreIgnoreCase(String genre);

    List<Track> findByYear(Integer year);

    List<Track> findByArtistIdAndTitleContainingIgnoreCase(Long artistId, String title);

}
