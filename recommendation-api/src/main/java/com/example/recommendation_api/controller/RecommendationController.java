package com.example.recommendation_api.controller;

import com.example.recommendation_api.entity.Ebook;
import com.example.recommendation_api.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    // Endpoint to get e-book recommendations for the user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ebook>> getRecommendations(@PathVariable Long userId) {
        List<Ebook> recommendations = recommendationService.getRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }
}
