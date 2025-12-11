package com.pedro.trackmix.TrackMix.service.impl;

import org.springframework.stereotype.Service;
import com.pedro.trackmix.TrackMix.service.UserService;
import com.pedro.trackmix.TrackMix.model.entity.User;
import com.pedro.trackmix.TrackMix.repository.UserRepository;
import lombok.*;
import java.util.List;

import com.pedro.trackmix.TrackMix.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        // No cambiamos createdAt, se mantiene la fecha original
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        
        User user = getUserById(id);
        userRepository.delete(user);
        
        /* 
        
        userRepository.delete(getUserById(id)); 
        
            * Alternativamente, se puede eliminar el usuario directamente
            * obteniéndolo primero para asegurar que existe.
        */
        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
