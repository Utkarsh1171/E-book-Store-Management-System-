package com.example.Review_and_Rating_APIs.repo;

import com.example.Review_and_Rating_APIs.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByEbookId(Long ebookId);
}
