package com.example.demo.controllers;

import com.example.demo.model.Payment;
import com.example.demo.model.Rental;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers/ranking")
public class CustomerRankingController {
    private final CustomerRepository repository;

    public CustomerRankingController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("bySpentMoney")
    public ResponseEntity<List<CustomerRankingEntry<Double>>> bySpentMoney(@RequestParam("chart") final Optional<String> chart) {
        return new ResponseEntity<>(repository.getAllWithSumPaymentAmount(), HttpStatus.OK);
    }

    @GetMapping("byWatchedMovies")
    public ResponseEntity<List<CustomerRankingEntry<Double>>> byWatchedMovies(@RequestParam("chart") final Optional<String> chart) {
        return new ResponseEntity<>(repository.findAll().stream()
                .limit(10)
                .map(CustomerEntry::from)
                .map(customer -> new CustomerRankingEntry<>(customer, 0.0))
                .toList(), HttpStatus.OK);
    }

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
