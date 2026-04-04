package com.example.energia.controller;

import com.example.energia.dto.LoginRequest;
import com.example.energia.dto.UserDto;
import com.example.energia.entity.User;
import com.example.energia.security.JwtTokenProvider;
import com.example.energia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    @PostMapping("/register")
    public User register(@RequestBody UserDto dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest dto) {
        User user = userService.login(dto);

        List<String> ruoli = List.of("ROLE_" + user.getRuolo().toString());

        String token = tokenProvider.generateToken(user.getEmail(), ruoli);
        return Map.of("token", token);
    }
}