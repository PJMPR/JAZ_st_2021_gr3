package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
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
@RequestMapping("rental")
public class RentalController {
    private final CustomerRepository repository;

    public RentalController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("incomeByMonth")
    public ResponseEntity<List<CustomerRecords.MonthIncomeEntry>> incomeByMonth(@RequestParam("chart") final Optional<String> chart, @RequestParam("year") final Optional<Integer> year) {
        final var list = year.isPresent() ? repository.getMonthIncomeForYear(year.get()) : repository.getMonthIncome();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("income")
    public ResponseEntity<List<CustomerRecords.MonthIncomeEntry>> income(@RequestParam("from") final String from, @RequestParam("to") final String to, @RequestParam("chart") final Optional<String> chart) {
        final var list = repository.getIncomeForRange(from, to);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
