package com.example.Review_and_Rating_APIs.controller;

import com.example.Review_and_Rating_APIs.model.Review;
import com.example.Review_and_Rating_APIs.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // API to add a review
    @PostMapping("/{ebookId}")
    public ResponseEntity<Review> addReview(
            @PathVariable Long ebookId,
            @RequestParam String username,
            @RequestParam String comment
    ) {
        Review review = reviewService.addReview(ebookId, username, comment);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    // API to get reviews for an e-book
    @GetMapping("/{ebookId}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long ebookId) {
        List<Review> reviews = reviewService.getReviews(ebookId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
