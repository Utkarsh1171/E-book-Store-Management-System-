package com.example.recommendation_api.service;

import com.example.recommendation_api.dto.ReadingHistoryDTO;
import com.example.recommendation_api.entity.Ebook;
import com.example.recommendation_api.entity.ReadingHistory;
import com.example.recommendation_api.entity.User;
import com.example.recommendation_api.repo.EbookRepository;
import com.example.recommendation_api.repo.ReadingHistoryRepository;
import com.example.recommendation_api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingHistoryService {

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EbookRepository ebookRepository;

    // Method to add a new reading history record
    public ReadingHistory addReadingHistory(ReadingHistoryDTO readingHistoryDTO) {
        // Fetch the User and Ebook based on the provided IDs
        User user = userRepository.findById(readingHistoryDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Ebook ebook = ebookRepository.findById(readingHistoryDTO.getEbookId())
                .orElseThrow(() -> new RuntimeException("Ebook not found"));

        // Create the ReadingHistory entity
        ReadingHistory readingHistory = ReadingHistory.builder()
                .user(user)
                .ebook(ebook)
                .action(readingHistoryDTO.getAction())
                .timestamp(readingHistoryDTO.getTimestamp())
                .build();

        // Save and return the saved entity
        return readingHistoryRepository.save(readingHistory);
    }
}
