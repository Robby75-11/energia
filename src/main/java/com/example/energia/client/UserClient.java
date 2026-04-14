package com.example.energia.client;

import com.example.energia.dto.UserResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component

public class UserClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public UserResponseDto getUserByEmail(String email, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token); // Authorization: Bearer <token>
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = "http://localhost:8080/users/email/" + email;

        ResponseEntity<UserResponseDto> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                UserResponseDto.class
        );

        return response.getBody();
    }
}