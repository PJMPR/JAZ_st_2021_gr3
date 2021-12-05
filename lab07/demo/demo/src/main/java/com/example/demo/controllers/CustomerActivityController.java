package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
import com.example.demo.repositories.CustomerRepository;
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
@RequestMapping("customers/activity")
public class CustomerActivityController {
    private final CustomerRepository repository;

    public CustomerActivityController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("rentMoviesByMonth")
    public ResponseEntity<List<CustomerRecords.MonthRentActivityEntry>> bySpentMoney(HttpServletResponse response, @RequestParam("chart") final Optional<String> chart, @RequestParam("year") final Optional<Integer> year, @RequestParam("userId") final Optional<Integer> userId) throws IOException {

        List<CustomerRecords.MonthRentActivityEntry> list;
        if (year.isPresent() && userId.isPresent()) {
            list = repository.getRentMoviesByMonthForYearAndUser(userId.get(), year.get());
        } else if (year.isPresent()) {
            list = repository.getRentMoviesByMonthForYear(year.get());
        } else if (userId.isPresent()) {
            list = repository.getRentMoviesByMonthForUser(userId.get());
        } else {
            list = repository.getRentMoviesByMonth();
        }

        if (chart.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ChartMaker.export(chart.get(), response, CustomerRecords.MonthRentActivityEntry.toDatasetEntryList(list), "Rent movies by month.");
        return null;
    }
}
