package com.example.Analytics_API.controller;

import com.example.Analytics_API.service.UsageStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/analytics")
public class UsageStatisticsController {

    @Autowired
    private UsageStatisticsService usageStatisticsService;

    // API to get the total number of users reading e-books
    @GetMapping("/total-users-reading")
    public long getTotalUsersReadingEbooks() {
        return usageStatisticsService.getTotalUsersReadingEbooks();
    }

    // API to get popular e-books based on reading history
    @GetMapping("/popular-ebooks")
    public List<Map<String, Object>> getPopularEbooks() {
        return usageStatisticsService.getPopularEbooks();
    }
}
