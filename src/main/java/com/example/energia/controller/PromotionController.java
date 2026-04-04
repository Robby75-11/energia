package com.example.energia.controller;

import com.example.energia.dto.PromotionRequestDto;
import com.example.energia.entity.PromotionRequest;
import com.example.energia.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @PostMapping("/request")
    public PromotionRequest requestPromotion(@RequestBody PromotionRequestDto dto) {
        return promotionService.createPromotion(dto);
    }

    @GetMapping("/user/{userId}")
    public List<PromotionRequest> getUserPromotions(@PathVariable Long userId) {
        return promotionService.getPromotionsByUser(userId);
    }
}