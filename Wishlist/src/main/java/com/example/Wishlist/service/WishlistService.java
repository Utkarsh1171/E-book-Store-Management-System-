package com.example.Wishlist.service;

import com.example.Wishlist.model.Book;
import com.example.Wishlist.model.User;
import com.example.Wishlist.model.Wishlist;
import com.example.Wishlist.repo.BookRepository;
import com.example.Wishlist.repo.UserRepository;
import com.example.Wishlist.repo.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    // Add a book to the user's wishlist
    public String addBookToWishlist(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setBook(book);
        wishlistRepository.save(wishlist);

        return "Book added to wishlist!";
    }

    // Remove a book from the user's wishlist
    @Transactional
    public String removeBookFromWishlist(Long userId, Long bookId) {
        wishlistRepository.deleteByUserIdAndBookId(userId, bookId);
        return "Book removed from wishlist!";
    }

    // Get the user's wishlist
    public List<Wishlist> getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
