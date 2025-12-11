package com.pedro.trackmix.TrackMix.mapper;

import java.time.LocalDateTime;

import com.pedro.trackmix.TrackMix.dto.UserRequestDto;
import com.pedro.trackmix.TrackMix.dto.UserResponseDto;
import com.pedro.trackmix.TrackMix.model.entity.User;


public class UserMapper {

    public static User toEntity(UserRequestDto dto) {
        return User.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public static void updateEntityFromDto(UserRequestDto dto, User user) {
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
    }
}

