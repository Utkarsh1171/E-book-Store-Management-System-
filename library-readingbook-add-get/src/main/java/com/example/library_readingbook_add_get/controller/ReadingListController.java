package com.example.library_readingbook_add_get.controller;

import com.example.library_readingbook_add_get.entity.ReadingList;
import com.example.library_readingbook_add_get.service.ReadingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-list")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;

    // Add to reading list
    @PostMapping("/add")
    public ResponseEntity<String> addToReadingList(@RequestParam Long userId, @RequestParam Long ebookId) {
        try {
            readingListService.addToReadingList(userId, ebookId);
            return ResponseEntity.ok("E-book added to reading list successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get a user's reading list
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReadingList>> getReadingList(@PathVariable Long userId) {
        List<ReadingList> readingList = readingListService.getReadingList(userId);
        return ResponseEntity.ok(readingList);
    }
}
