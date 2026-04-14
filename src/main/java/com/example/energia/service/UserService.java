package com.example.energia.service;

import com.example.energia.entity.User;
import com.example.energia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
private PasswordEncoder passwordEncoder;

    // Registrazione nuovo utente
    public User registraUser(User user) {
        user.setRegistratoIl(LocalDateTime.now());
        // TODO: hash password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Login (verifica email + password)
    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    // Recupera tutti gli utenti
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Recupera utente per ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Cancella utente
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}