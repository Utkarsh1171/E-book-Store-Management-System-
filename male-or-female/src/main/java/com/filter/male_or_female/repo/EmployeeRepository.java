package com.filter.male_or_female.repo;

import com.filter.male_or_female.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
