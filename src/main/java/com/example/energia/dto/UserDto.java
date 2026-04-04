package com.example.energia.dto;

import lombok.Data;

@Data

public class UserDto {
    private Long id;
    private String nome;
    private String email;
    private String password;
}
