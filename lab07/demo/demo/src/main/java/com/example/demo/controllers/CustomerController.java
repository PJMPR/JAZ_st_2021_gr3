package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.model.Rental;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    CustomerRepository repository;

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<List<Timestamp>> get(@PathVariable("id") int id){
        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
        System.out.println(t);
        return ResponseEntity.ok(repository.getById(id)
                .getRentalsByCustomerId()
                .stream()
                .map(Rental::getLastUpdate)
                .toList());
    }
}
