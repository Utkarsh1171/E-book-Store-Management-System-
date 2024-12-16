package com.example.JSON_To_POJO.service;

import com.example.JSON_To_POJO.model.Contract;
import com.example.JSON_To_POJO.repo.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    // Other CRUD methods as needed
}
