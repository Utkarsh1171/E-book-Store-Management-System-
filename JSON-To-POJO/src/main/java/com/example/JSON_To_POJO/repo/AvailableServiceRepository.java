package com.example.JSON_To_POJO.repo;

import com.example.JSON_To_POJO.model.AvailableService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableServiceRepository extends JpaRepository<AvailableService, Long> {
}
