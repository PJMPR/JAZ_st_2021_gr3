package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.interfaces.CustomerRankingBySpentMoneyEntry;
import com.example.demo.repositories.interfaces.CustomerRankingByWatchedMoviesEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public ResponseEntity<List<CustomerRankingBySpentMoneyEntry>> bySpentMoney(HttpServletResponse response, @RequestParam("chart") final Optional<String> chart) throws IOException {
        final var list = repository.get10CustomersByMostSpentMoney();

        if (chart.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ChartMaker.export(chart.get(), response, CustomerRankingBySpentMoneyEntry.toDatasetEntryList(list), "By spent money.");
        return null;
    }

    @GetMapping("byWatchedMovies")
    public ResponseEntity<List<CustomerRankingByWatchedMoviesEntry>> byWatchedMovies(HttpServletResponse response, @RequestParam("chart") final Optional<String> chart) throws IOException {
        final var list = repository.get10CustomersByMostMoviesWatched();

        if (chart.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ChartMaker.export(chart.get(), response, CustomerRankingByWatchedMoviesEntry.toDatasetEntryList(list), "By watched movies.");
        return null;
    }
}
