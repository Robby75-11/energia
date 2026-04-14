package com.example.energia.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document(collection =  "users")

public class User {
    @Id

    private String id;

    private String nome;

    private String email;

    private String password;

    private LocalDateTime registratoIl = LocalDateTime.now();


}
