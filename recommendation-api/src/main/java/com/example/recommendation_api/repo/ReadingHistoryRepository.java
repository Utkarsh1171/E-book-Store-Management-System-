package com.example.recommendation_api.repo;

import com.example.recommendation_api.entity.ReadingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReadingHistoryRepository extends JpaRepository<ReadingHistory, Long> {

    List<ReadingHistory> findByUserId(Long userId);

}
