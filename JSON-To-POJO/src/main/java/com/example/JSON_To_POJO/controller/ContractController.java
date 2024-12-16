package com.example.JSON_To_POJO.controller;

import com.example.JSON_To_POJO.model.Contract;
import com.example.JSON_To_POJO.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    // Other endpoints for creating, updating, and deleting contracts
}
