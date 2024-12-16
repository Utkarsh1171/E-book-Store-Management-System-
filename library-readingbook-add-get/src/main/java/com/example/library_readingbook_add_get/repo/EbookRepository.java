package com.example.library_readingbook_add_get.repo;

import com.example.library_readingbook_add_get.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EbookRepository extends JpaRepository<Ebook, Long> {

    // Example query methods
    List<Ebook> findByGenreInOrAuthorIn(List<String> genres, List<String> authors);

    List<Ebook> findByPublicationDateBetween(LocalDate startDate, LocalDate endDate);
}
