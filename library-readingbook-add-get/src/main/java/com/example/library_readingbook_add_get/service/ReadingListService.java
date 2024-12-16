package com.example.library_readingbook_add_get.service;

import com.example.library_readingbook_add_get.entity.Ebook;
import com.example.library_readingbook_add_get.entity.ReadingList;
import com.example.library_readingbook_add_get.entity.User;
import com.example.library_readingbook_add_get.repo.EbookRepository;
import com.example.library_readingbook_add_get.repo.ReadingListRepository;
import com.example.library_readingbook_add_get.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private EbookRepository ebookRepository;

    @Autowired
    private UserRepository userRepository;

    // Add an e-book to the reading list
    public ReadingList addToReadingList(Long userId, Long ebookId) {
        if (readingListRepository.existsByUserIdAndEbookId(userId, ebookId)) {
            throw new RuntimeException("E-book already exists in the reading list.");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Ebook ebook = ebookRepository.findById(ebookId).orElseThrow(() -> new RuntimeException("E-book not found"));

        ReadingList readingList = new ReadingList(null, user, ebook);
        return readingListRepository.save(readingList);
    }

    // Get a user's reading list
    public List<ReadingList> getReadingList(Long userId) {
        return readingListRepository.findByUserId(userId);
    }
}
