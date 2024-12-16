package com.filter.male_or_female.controller;

import com.filter.male_or_female.dto.GenderCountResponse;
import com.filter.male_or_female.entity.Employee;
import com.filter.male_or_female.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/count")
    public ResponseEntity<GenderCountResponse> getEmployeeCount() {
        // Use the service methods to count male and female employees
        long maleCount = employeeService.countMaleEmployees();
        long femaleCount = employeeService.countFemaleEmployees();

        // Create the response object with male and female counts
        GenderCountResponse genderCountResponse = new GenderCountResponse(maleCount, femaleCount);
        return ResponseEntity.ok(genderCountResponse);
    }
}
