package com.pedro.trackmix.TrackMix.repository;

import com.pedro.trackmix.TrackMix.model.entity.ListeningSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ListeningSessionRepository extends JpaRepository<ListeningSession, Long> {

    List<ListeningSession> findByUserId(Long userId);

    List<ListeningSession> findByUserIdAndListenedAtBetween(Long userId, LocalDateTime from, LocalDateTime to);

    List<ListeningSession> findByUserIdOrderByListenedAtDesc(Long userId);
}