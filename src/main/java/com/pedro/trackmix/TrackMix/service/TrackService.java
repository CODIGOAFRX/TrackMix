package com.pedro.trackmix.TrackMix.service;
import java.util.List;

import com.pedro.trackmix.TrackMix.model.entity.Track;
public interface TrackService {

    Track getTrackById(Long id);

    Track createTrack(Track track);

    Track updateTrack(Long id, Track track);

    void deleteTrack(Long id);

    List<Track> getAllTracks();
}
