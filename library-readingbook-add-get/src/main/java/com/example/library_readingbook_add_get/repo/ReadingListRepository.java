package com.example.library_readingbook_add_get.repo;

import com.example.library_readingbook_add_get.entity.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

    List<ReadingList> findByUserId(Long userId);

    boolean existsByUserIdAndEbookId(Long userId, Long ebookId);
}
