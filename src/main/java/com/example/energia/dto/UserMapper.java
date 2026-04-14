package com.example.energia.dto;

import com.example.energia.entity.User;

public class UserMapper {

    // Converte User entity in UserResponseDto (senza password)
    public static UserResponseDto toDto(User user) {
        if (user == null) return null;

        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());      // MongoDB ID è String
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }
}

