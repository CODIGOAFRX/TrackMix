package com.pedro.trackmix.TrackMix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedro.trackmix.TrackMix.model.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

}
