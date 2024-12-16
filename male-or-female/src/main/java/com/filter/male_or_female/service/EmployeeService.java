package com.filter.male_or_female.service;

import com.filter.male_or_female.entity.Employee;
import com.filter.male_or_female.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public long countMaleEmployees() {
        return employeeRepository.findAll().stream() // Get all employees from the DB
                .filter(employee -> "male".equalsIgnoreCase(employee.getGender())) // Filter by gender "male"
                .count(); // Count the filtered result
    }

    public long countFemaleEmployees() {
        return employeeRepository.findAll().stream()
                .filter(employee -> "female".equalsIgnoreCase(employee.getGender()))
                .count();
    }

}
