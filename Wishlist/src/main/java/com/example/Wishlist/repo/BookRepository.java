package com.example.Wishlist.repo;

import com.example.Wishlist.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
