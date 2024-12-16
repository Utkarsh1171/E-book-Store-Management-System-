package com.example.Analytics_API.repo;

import com.example.Analytics_API.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
}
