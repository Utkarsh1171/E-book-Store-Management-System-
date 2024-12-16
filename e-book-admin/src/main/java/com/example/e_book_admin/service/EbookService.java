package com.example.e_book_admin.service;

import com.example.e_book_admin.Repository.EbookRepository;
import com.example.e_book_admin.entity.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookRepository ebookRepository;

    public Ebook addEbook(Ebook ebook) {
        return ebookRepository.save(ebook);
    }

    public Ebook updateEbook(Long id, Ebook ebookDetails) {
        Ebook ebook = ebookRepository.findById(id).orElseThrow(() -> new RuntimeException("E-book not found"));
        ebook.setTitle(ebookDetails.getTitle());
        ebook.setAuthor(ebookDetails.getAuthor());
        ebook.setGenre(ebookDetails.getGenre());
        ebook.setDescription(ebookDetails.getDescription());
        ebook.setPublicationDate(ebookDetails.getPublicationDate());
        ebook.setRating(ebookDetails.getRating());
        ebook.setCategory(ebookDetails.getCategory());
        return ebookRepository.save(ebook);
    }

    public void deleteEbook(Long id) {
        ebookRepository.deleteById(id);
    }

    public Ebook getEbookDetails(Long id) {
        return ebookRepository.findById(id).orElseThrow(() -> new RuntimeException("E-book not found"));
    }

    public List<Ebook> listAllEbooks() {
        return ebookRepository.findAll();
    }

    public List<Ebook> filterEbooks(String genre, String author, String category) {
        if (genre != null) {
            return ebookRepository.findByGenre(genre);
        } else if (author != null) {
            return ebookRepository.findByAuthor(author);
        } else if (category != null) {
            return ebookRepository.findByCategory(category);
        } else {
            return ebookRepository.findAll();
        }
    }
}
