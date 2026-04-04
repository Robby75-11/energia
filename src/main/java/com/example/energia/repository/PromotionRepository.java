package com.example.energia.repository;

import com.example.energia.entity.PromotionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PromotionRepository extends JpaRepository<PromotionRequest, Long> {
    List<PromotionRequest> findByUserId(Long userId);
}
