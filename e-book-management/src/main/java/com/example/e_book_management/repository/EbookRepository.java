package com.example.e_book_management.repository;

import com.example.e_book_management.model.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EbookRepository extends JpaRepository<Ebook, Long> {

    // Search by title, author, or genre (case-insensitive)
    List<Ebook> findByTitleContainingIgnoreCase(String title);

    List<Ebook> findByAuthorContainingIgnoreCase(String author);

    List<Ebook> findByGenreContainingIgnoreCase(String genre);

    // Filter based on ratings, publication date, or category
    List<Ebook> findByRatingGreaterThanEqual(double rating);

    List<Ebook> findByPublicationDateAfter(LocalDate date);

    List<Ebook> findByCategoryContainingIgnoreCase(String category);

    public List<Ebook> findByRating(double d);
}
