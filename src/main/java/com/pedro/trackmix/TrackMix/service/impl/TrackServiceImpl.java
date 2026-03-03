package com.pedro.trackmix.TrackMix.service.impl;

import com.pedro.trackmix.TrackMix.exception.ResourceNotFoundException;
import com.pedro.trackmix.TrackMix.model.entity.Track;
import com.pedro.trackmix.TrackMix.repository.TrackRepository;
import com.pedro.trackmix.TrackMix.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Override
    public Track getTrackById(Long id) {
        return trackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Track not found"));
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track updateTrack(Long id, Track trackUpdated) {
        Track track = getTrackById(id);
        track.setAlbum(trackUpdated.getAlbum());
        track.setArtist(trackUpdated.getArtist());
        track.setDuration(trackUpdated.getDuration());
        track.setGenre(trackUpdated.getGenre());
        track.setTitle(trackUpdated.getTitle());
        track.setYear(trackUpdated.getYear());
        return track;
    }

    @Override
    public void deleteTrack(Long id) {
        Track track = getTrackById(id);
        trackRepository.delete(track);
    }

}
