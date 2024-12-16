package com.example.recommendation_api.service;

import com.example.recommendation_api.entity.Ebook;
import com.example.recommendation_api.entity.ReadingHistory;
import com.example.recommendation_api.repo.EbookRepository;
import com.example.recommendation_api.repo.ReadingHistoryRepository;
import com.example.recommendation_api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private EbookRepository ebookRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to get recommendations based on user's reading history
    public List<Ebook> getRecommendations(Long userId) {
        // Step 1: Get user's reading history (purchased or read books)
        List<ReadingHistory> history = readingHistoryRepository.findByUserId(userId);

        if (history.isEmpty()) {
            return List.of();  // No recommendations if no history exists
        }

        // Step 2: Extract genres/authors from the user's history (you can use more advanced logic here)
        List<String> genres = history.stream()
                .map(entry -> entry.getEbook().getGenre())
                .distinct()
                .collect(Collectors.toList());

        List<String> authors = history.stream()
                .map(entry -> entry.getEbook().getAuthor())
                .distinct()
                .collect(Collectors.toList());

        // Step 3: Get books that match the genres or authors from the user's history
        List<Ebook> recommendedBooks = ebookRepository.findByGenreInOrAuthorIn(genres, authors);

        // Step 4: Return recommendations
        return recommendedBooks.stream()
                .filter(ebook -> !history.stream().anyMatch(entry -> entry.getEbook().equals(ebook))) // Exclude already read/purchased books
                .collect(Collectors.toList());
    }
}
