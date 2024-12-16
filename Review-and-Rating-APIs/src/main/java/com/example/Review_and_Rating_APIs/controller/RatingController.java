package com.example.Review_and_Rating_APIs.controller;

import com.example.Review_and_Rating_APIs.model.Rating;
import com.example.Review_and_Rating_APIs.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // API to rate an e-book
    @PostMapping("/{ebookId}")
    public ResponseEntity<Rating> rateEbook(
            @PathVariable Long ebookId,
            @RequestParam String username,
            @RequestParam float ratingValue
    ) {
        if (ratingValue < 1 || ratingValue > 5) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Invalid rating
        }

        Rating rating = ratingService.rateEbook(ebookId, username, ratingValue);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
}
