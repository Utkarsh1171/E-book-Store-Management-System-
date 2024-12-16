package com.example.e_book_management.controller;

import com.example.e_book_management.model.Ebook;
import com.example.e_book_management.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ebooks")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/search/title")
    public ResponseEntity<List<Ebook>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(ebookService.searchByTitle(title));
    }

    @GetMapping("/search/author")
    public ResponseEntity<List<Ebook>> searchByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(ebookService.searchByAuthor(author));
    }

    @GetMapping("/search/genre")
    public ResponseEntity<List<Ebook>> searchByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(ebookService.searchByGenre(genre));
    }

    @GetMapping("/filter/rating")
    public ResponseEntity<List<Ebook>> filterByRating(@RequestParam double rating) {
        return ResponseEntity.ok(ebookService.filterByRating(rating));
    }

    @GetMapping("/filter/publication-date")
    public ResponseEntity<List<Ebook>> filterByPublicationDate(@RequestParam String date) {
        LocalDate publicationDate = LocalDate.parse(date);
        return ResponseEntity.ok(ebookService.filterByPublicationDate(publicationDate));
    }

    @GetMapping("/filter/category")
    public ResponseEntity<List<Ebook>> filterByCategory(@RequestParam String category) {
        return ResponseEntity.ok(ebookService.filterByCategory(category));
    }
}
