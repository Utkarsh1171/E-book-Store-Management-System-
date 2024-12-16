package com.example.Analytics_API.service;

import com.example.Analytics_API.entity.ReadingHistory;
import com.example.Analytics_API.repo.EbookRepository;
import com.example.Analytics_API.repo.ReadingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsageStatisticsService {

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private EbookRepository ebookRepository;

    // Method to get the total number of users reading e-books
    public long getTotalUsersReadingEbooks() {
        return readingHistoryRepository.countDistinctByUser();
    }

    // Method to get popular e-books based on the number of times they were read
    public List getPopularEbooks() {
        // Get the reading history grouped by e-book with the count of times each e-book was read
        return readingHistoryRepository.findAll().stream()
                .collect(Collectors.groupingBy(ReadingHistory::getEbook, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> Map.of("ebook", entry.getKey().getTitle(), "timesRead", entry.getValue()))
                .sorted((a, b) -> Long.compare((Long) b.get("timesRead"), (Long) a.get("timesRead"))) // Sort by popularity
                .collect(Collectors.toList());
    }
}
