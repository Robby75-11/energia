package com.example.energia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "promotion_requests")
public class PromotionRequest {
    @Id
    @GeneratedValue
    private Long id;

    // Rimuoviamo ManyToOne → non serve foreign key
    @Column(name = "user_id", nullable = false)
    private Long userId;

    private LocalDateTime requestDate = LocalDateTime.now();
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED
}
