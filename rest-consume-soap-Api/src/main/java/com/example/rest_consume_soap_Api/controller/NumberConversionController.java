package com.example.rest_consume_soap_Api.controller;

import com.example.rest_consume_soap_Api.service.NumberConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberConversionController {

    @Autowired
    private NumberConversionService numberConversionService;

    @GetMapping("/convert/{number}")
    public String convertNumber(@PathVariable String number) {
        return numberConversionService.convertNumber(number);
    }
}
