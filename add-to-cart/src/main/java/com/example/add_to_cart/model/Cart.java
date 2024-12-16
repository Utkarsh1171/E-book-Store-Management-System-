package com.example.add_to_cart.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "ebook_id")
    private Long ebookId;

    @Column(name = "quantity")
    private int quantity;
}
