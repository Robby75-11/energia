package com.example.energia.entity;

import com.example.energia.enumeration.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="app_user")

public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable =false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role ruolo; // enum Role { UTENTE, AMMINISTRATORE }
}
