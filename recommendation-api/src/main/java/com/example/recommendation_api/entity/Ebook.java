package com.example.recommendation_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDate;

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

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    private String description; // Description of the book
}
