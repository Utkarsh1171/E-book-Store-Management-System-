package com.example.Review_and_Rating_APIs.service;

import com.example.Review_and_Rating_APIs.model.Review;
import com.example.Review_and_Rating_APIs.repo.ReviewRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Long ebookId, String username, String comment) {
        Review review = new Review();
        review.setEbookId(ebookId);
        review.setUsername(username);
        review.setComment(comment);
        review.setCreatedDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public List<Review> getReviews(Long ebookId) {
        return reviewRepository.findByEbookId(ebookId);
    }
}
