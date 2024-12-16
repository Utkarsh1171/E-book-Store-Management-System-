package com.example.Analytics_API.repo;

import com.example.Analytics_API.entity.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReadingHistoryRepository extends JpaRepository<ReadingHistory, Long> {

    // Custom query to count distinct users who have reading history
    @Query("SELECT COUNT(DISTINCT r.user) FROM ReadingHistory r")
    long countDistinctByUser();
}
