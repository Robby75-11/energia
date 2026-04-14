package com.example.energia;

import com.example.energia.entity.User;
import com.example.energia.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnergiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergiaApplication.class, args);
	}


}