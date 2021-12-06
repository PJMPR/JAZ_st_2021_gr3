package com.example.demo.controllers;

import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.repositories.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerDTO>> giveTopTenCustomersBySpentMoney(){
        return ResponseEntity.ok(customerService.setCustomers().stream()
                .sorted(Comparator.comparing(CustomerDTO::getSpent).reversed())
                .limit(10).collect(Collectors.toList()));
    }
}
