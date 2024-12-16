package com.example.recommendation_api.controller;

import com.example.recommendation_api.dto.ReadingHistoryDTO;
import com.example.recommendation_api.entity.ReadingHistory;
import com.example.recommendation_api.service.ReadingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reading-history")
public class ReadingHistoryController {

    @Autowired
    private ReadingHistoryService readingHistoryService;

    // POST endpoint to add a new reading history
    @PostMapping("/add")
    public ResponseEntity<ReadingHistory> addReadingHistory(@RequestBody ReadingHistoryDTO readingHistoryDTO) {
        ReadingHistory readingHistory = readingHistoryService.addReadingHistory(readingHistoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(readingHistory);
    }
}
