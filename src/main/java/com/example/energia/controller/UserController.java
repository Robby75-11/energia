package com.example.energia.controller;

import com.example.energia.dto.UserResponseDto;
import com.example.energia.dto.UserMapper;
import com.example.energia.entity.User;
import com.example.energia.security.JwtTokenProvider;
import com.example.energia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    // Registrazione
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody User user) {
        User savedUser = userService.registraUser(user);
        return ResponseEntity.ok(UserMapper.toDto(savedUser));
    }

    // Login con JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> userOpt = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String token = tokenProvider.generateToken(user.getEmail());
            return ResponseEntity.ok(new LoginResponse(token, UserMapper.toDto(user)));
        } else {
            return ResponseEntity.status(401).body("Email o password non corretti");
        }
    }

    // Recupera tutti gli utenti
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<UserResponseDto> users = userService.getAllUsers()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    // Recupera utente per ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(u -> ResponseEntity.ok(UserMapper.toDto(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cancella utente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    // Classe interna per risposta login
    @lombok.Data
    @lombok.AllArgsConstructor
    static class LoginResponse {
        private String token;
        private UserResponseDto user;
    }
}