package com.pedro.trackmix.TrackMix.service;
import java.util.List;

import com.pedro.trackmix.TrackMix.model.entity.User;

public interface UserService {
    
    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
    
    List<User> getAllUsers();
}
