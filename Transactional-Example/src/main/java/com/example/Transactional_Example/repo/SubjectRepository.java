package com.example.Transactional_Example.repo;

import com.example.Transactional_Example.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
