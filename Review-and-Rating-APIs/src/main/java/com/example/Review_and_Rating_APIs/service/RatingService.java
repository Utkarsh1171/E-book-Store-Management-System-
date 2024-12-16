package com.example.Review_and_Rating_APIs.service;

import com.example.Review_and_Rating_APIs.model.Rating;
import com.example.Review_and_Rating_APIs.repo.RatingRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating rateEbook(Long ebookId, String username, float ratingValue) {
        Rating rating = ratingRepository.findByEbookIdAndUsername(ebookId, username)
                .orElse(new Rating());

        rating.setEbookId(ebookId);
        rating.setUsername(username);
        rating.setRating(ratingValue);
        rating.setCreatedDate(LocalDateTime.now());
        return ratingRepository.save(rating);
    }
}
