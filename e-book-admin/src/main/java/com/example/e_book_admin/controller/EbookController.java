package com.example.e_book_admin.controller;

import com.example.e_book_admin.entity.Ebook;
import com.example.e_book_admin.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ebooks")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    // Add E-book (admin only)
    @PostMapping("/add")
    public ResponseEntity<Ebook> addEbook(@RequestBody Ebook ebook) {
        Ebook newEbook = ebookService.addEbook(ebook);
        return ResponseEntity.ok(newEbook);
    }

    // Update E-book (admin only)
    @PutMapping("/update/{id}")
    public ResponseEntity<Ebook> updateEbook(@PathVariable Long id, @RequestBody Ebook ebookDetails) {
        Ebook updatedEbook = ebookService.updateEbook(id, ebookDetails);
        return ResponseEntity.ok(updatedEbook);
    }

    // Delete E-book (admin only)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEbook(@PathVariable Long id) {
        ebookService.deleteEbook(id);
        return ResponseEntity.ok("E-book deleted successfully");
    }

    // Get E-book Details
    @GetMapping("/{id}")
    public ResponseEntity<Ebook> getEbookDetails(@PathVariable Long id) {
        Ebook ebook = ebookService.getEbookDetails(id);
        return ResponseEntity.ok(ebook);
    }

    // List all E-books or filter by genre, author, category
    @GetMapping("/list")
    public ResponseEntity<List<Ebook>> listEbooks(@RequestParam(required = false) String genre,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category) {
        List<Ebook> ebooks = ebookService.filterEbooks(genre, author, category);
        return ResponseEntity.ok(ebooks);
    }
}
