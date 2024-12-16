package com.example.Review_and_Rating_APIs.repo;

import com.example.Review_and_Rating_APIs.model.Rating;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByEbookIdAndUsername(Long ebookId, String username);
}
