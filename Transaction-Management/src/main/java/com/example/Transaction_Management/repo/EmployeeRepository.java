package com.example.Transaction_Management.repo;

import com.example.Transaction_Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
