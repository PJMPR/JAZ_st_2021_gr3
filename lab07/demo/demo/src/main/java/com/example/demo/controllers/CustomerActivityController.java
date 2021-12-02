package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers/activity")
public class CustomerActivityController {
    private final CustomerRepository repository;

    public CustomerActivityController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("rentMoviesByMonth")
    public ResponseEntity<List<CustomerRankingBySpentMoneyEntry>> bySpentMoney(@RequestParam("chart") final Optional<String> chart) {
        final var list = repository.get10CustomersByMostSpentMoney()
                .stream()
                .map(CustomerRankingBySpentMoneyEntry::from)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
