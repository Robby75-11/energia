package com.example.energia.service;

import com.example.energia.dto.PromotionRequestDto;
import com.example.energia.entity.PromotionRequest;
import com.example.energia.entity.User;
import com.example.energia.repository.PromotionRepository;
import com.example.energia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;
    private final UserRepository userRepository;

    public PromotionRequest createPromotion(PromotionRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        PromotionRequest pr = new PromotionRequest();
        pr.setUser(user);
        pr.setStatus("PENDING");
        return promotionRepository.save(pr);
    }

    public List<PromotionRequest> getPromotionsByUser(Long userId) {
        return promotionRepository.findByUserId(userId);
    }
}
