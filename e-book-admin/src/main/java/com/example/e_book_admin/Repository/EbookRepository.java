package com.example.e_book_admin.Repository;

import com.example.e_book_admin.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EbookRepository extends JpaRepository<Ebook, Long> {

    List<Ebook> findByGenre(String genre);

    List<Ebook> findByAuthor(String author);

    List<Ebook> findByCategory(String category);

    List<Ebook> findByTitleContaining(String title);
}
