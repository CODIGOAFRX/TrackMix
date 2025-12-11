package com.pedro.trackmix.TrackMix.controller;

import com.pedro.trackmix.TrackMix.dto.UserRequestDto;
import com.pedro.trackmix.TrackMix.dto.UserResponseDto;
import com.pedro.trackmix.TrackMix.mapper.UserMapper;
import com.pedro.trackmix.TrackMix.model.entity.User;
import com.pedro.trackmix.TrackMix.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    // Create User
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        User user = UserMapper.toEntity(userRequestDto);
        User createdUser = userService.createUser(user);
        return UserMapper.toDto(createdUser) ;
    }

    // Get User by ID
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return UserMapper.toDto(user);
    }

    // Get All Users
    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers()
            .stream()
            .map(UserMapper::toDto) // Toma cada User y lo convierte a UserResponseDto usando el método estático toDto
            .collect(Collectors.toList()); // Recoge los UserResponseDto en una lista
    }

    // Update User
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto userRequestDto) {
        
        // Obetenemoa el usuario actual 
        User existingUser = userService.getUserById(id);

        // Actualizamos los campos desde el DTO (sin tocar createdAt)
        UserMapper.updateEntityFromDto(userRequestDto, existingUser);

        // Guardamos los cambios
        User updatedUser = userService.updateUser(id, existingUser);

        // Devolvemos el DTO actualizado
        return UserMapper.toDto(updatedUser);
    }

    // Delete User
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}