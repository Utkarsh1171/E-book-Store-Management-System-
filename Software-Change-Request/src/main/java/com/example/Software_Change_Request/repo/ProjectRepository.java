package com.example.Software_Change_Request.repo;

import com.example.Software_Change_Request.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author shiva
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // You can define custom query methods here if needed
    Optional<Project> findByName(String name); // Example of a custom method
}
