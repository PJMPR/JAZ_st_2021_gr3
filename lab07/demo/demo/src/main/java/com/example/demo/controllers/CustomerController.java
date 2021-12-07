package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class CustomerController {

    CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("{type}/{criteria}")
    public ResponseEntity get(@PathVariable("type") String type, @PathVariable("criteria") String critieria, @RequestParam(value = "chart", required = false) String chart, @RequestParam(value = "year", required = false) String year, @RequestParam(value = "customerid", required = false) String id) {
        return new ResponseEntity<>(repository.getById(Integer.parseInt(id)), HttpStatus.OK);
    }
}