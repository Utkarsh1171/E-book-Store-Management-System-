package com.example.JSON_To_POJO.repo;

import com.example.JSON_To_POJO.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
