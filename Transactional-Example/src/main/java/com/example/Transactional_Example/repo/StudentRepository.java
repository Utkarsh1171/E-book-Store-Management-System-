package com.example.Transactional_Example.repo;

import com.example.Transactional_Example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
