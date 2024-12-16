package com.example.e_book_admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ebooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private String description;
    private String publicationDate;
    private double rating;
    private String category;
    private Double price;

    // Additional fields can be added here as needed
}
