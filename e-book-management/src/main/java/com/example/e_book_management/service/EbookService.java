package com.example.e_book_management.service;

import com.example.e_book_management.model.Ebook;
import com.example.e_book_management.repository.EbookRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookRepository ebookRepository;

    // Search by title, author, or genre
    public List<Ebook> searchByTitle(String title) {
        return ebookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Ebook> searchByAuthor(String author) {
        return ebookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Ebook> searchByGenre(String genre) {
        return ebookRepository.findByGenreContainingIgnoreCase(genre);
    }

    // Filter by rating, publication date, or category
    public List<Ebook> filterByRating(double rating) {
        return ebookRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Ebook> filterByPublicationDate(LocalDate date) {
        return ebookRepository.findByPublicationDateAfter(date);
    }

    public List<Ebook> filterByCategory(String category) {
        return ebookRepository.findByCategoryContainingIgnoreCase(category);
    }
}
