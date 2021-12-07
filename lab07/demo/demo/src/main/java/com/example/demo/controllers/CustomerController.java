package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.CustomerStats;
import com.example.demo.model.RentalStats;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("customers")
public class CustomerController {
    CustomerService = customerService;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    CustomerRepository repository;

    @GetMapping
    @RequestMapping("ranking/bySpentMoney")
    public ResponseEntity getByMoneyChart(@PathVariable("chart") String chart) throws IOException {
        if(chart.equals("linear")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerLinearChart(
                            "Customers by money spent",
                            "money",
                            customerService.rankCustomersByMoneySpent()));
        }else if (chart.equals("bar")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerBarChart(
                            "Customers by money spent",
                            "money",
                            "",
                            "Money spent",
                            customerService.rankCustomersByMoneySpent()));
        }
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);



}
