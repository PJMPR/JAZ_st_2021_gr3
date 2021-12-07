package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("customers")
public class CustomerController {

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    CustomerRepository repository;

    @GetMapping("ranking/bySpentMoney")
    public ResponseEntity<List<CustomerRecords.CustomerRankingBySpentMoneyEntry>> bySpentMoneya() {
        return new ResponseEntity<>(repository.get10CustomersByMostSpentMoney(), HttpStatus.OK);
    }

    @GetMapping("ranking/byWatchedMovies")
    public ResponseEntity<List<CustomerRecords.CustomerRankingByWatchedMoviesEntry>> byWatchedMovies() {
        return new ResponseEntity<>(repository.get10CustomersByMostMoviesWatched(), HttpStatus.OK);
    }

    @GetMapping("activity/rentMoviesByMonth")
    public ResponseEntity<List<CustomerRecords.MonthCountRankingEntry>> bySpentMoney(@RequestParam("year") final Optional<Integer> year) {
        return new ResponseEntity<>(repository.rentMoviesByMonth(year.get()), HttpStatus.OK);
    }

    @GetMapping("Rental/incomebyMonth")
    public ResponseEntity<List<CustomerRecords.MonthIncomeRankingEntry>> byIncomeMonth(@RequestParam("year") final Optional<Integer> year) {
        return new ResponseEntity<>(repository.incomeMoviesByMonth(year.get()), HttpStatus.OK);
    }
}
