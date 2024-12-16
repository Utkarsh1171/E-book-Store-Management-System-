package com.example.e_book_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ebooks")  // Specifies the table name in the database
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private String category;

    // Default constructor
    public Ebook() {
    }

    // Constructor with all fields (except ID, since it's auto-generated)
    public Ebook(String title, String author, String genre, LocalDate publicationDate, double rating, String category) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.rating = rating;
        this.category = category;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // ToString method for easier logging
    @Override
    public String toString() {
        return "Ebook{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", genre='" + genre + '\''
                + ", publicationDate=" + publicationDate
                + ", rating=" + rating
                + ", category='" + category + '\''
                + '}';
    }
}
