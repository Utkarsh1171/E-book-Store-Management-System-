package com.example.Transaction_Management.service;

import com.example.Transaction_Management.model.Address;
import com.example.Transaction_Management.model.Employee;
import com.example.Transaction_Management.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

    @Transactional
    public Employee addEmployee(Employee employee) throws Exception {
        Employee employeeSavedToDB = this.employeeRepository.save(employee);

        Address address = new Address();
        address.setId(123L);
        address.setAddress("Varanasi");
        address.setEmployee(employee);

        this.addressService.addAddress(address);
        return employeeSavedToDB;
    }
}
