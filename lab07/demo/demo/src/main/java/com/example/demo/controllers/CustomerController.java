package com.example.demo.controllers;

import com.example.demo.DTO.CustomerStats;
import com.example.demo.DTO.RentalStats;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("Customers")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping
    @RequestMapping("ranking/bySpentMoney")
    public ResponseEntity<List<CustomerStats>> getByMoney() {
        return ResponseEntity.ok(customerService.byMoneySpent());
    }

    @GetMapping
    @RequestMapping("ranking/bySpentMoney.jpg/{chart}")
    public ResponseEntity getByMoneyChart(@PathVariable("chart") String chart) throws IOException {
        switch (chart) {
            case "pie":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateCustomerPieChart(
                                "Customers by money spent",
                                "money",
                                customerService.byMoneySpent()));
            case "bar":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateCustomerBarChart(
                                "Customers by money spent",
                                "money",
                                "",
                                "Money spent",
                                customerService.byMoneySpent()));
        }
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @RequestMapping("ranking/byWatchedMovies")
    public ResponseEntity<List<CustomerStats>> getByWatchedMovies() {
        return ResponseEntity.ok(customerService.byWatchedMovies());
    }

    @GetMapping
    @RequestMapping("ranking/byWatchedMovies.jpg/{chart}")
    public ResponseEntity getByMoviesChart(@PathVariable("chart") String chart) throws IOException {
        switch (chart) {
            case "bar":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateCustomerBarChart(
                                "Movies watched",
                                "movies",
                                "",
                                "movies",
                                customerService.byWatchedMovies()));
            case "pie":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateCustomerPieChart(
                                "Customers by movies watched",
                                "movies",
                                customerService.byWatchedMovies()));
        }

        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @RequestMapping("activity/rentMoviesByMonth/{year}")
    public ResponseEntity<List<RentalStats>> getRentMoviesByMonth(@PathVariable("year") int year) {
        return ResponseEntity.ok(customerService.rentMoviesByMonths(year));
    }

    @GetMapping
    @RequestMapping("/activity/rentMoviesByMonth/{year}/{id}")
    public ResponseEntity getMoviesForCustomer(@PathVariable int year, @PathVariable int id) {
        return ResponseEntity.ok(customerService.getMoviesForCustomer(year, id));
    }

    @GetMapping
    @RequestMapping("activity/rentMoviesByMonth/{chart}/{year}.")
    public ResponseEntity getRentMoviesByMonthChart(@PathVariable("year") int year, @PathVariable("chart") String chart) throws IOException {
        switch (chart) {
            case "bar":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateRentalBarChart(
                                "Movies rental by month",
                                "months",
                                "rentals",
                                customerService.rentMoviesByMonths(year)
                        ));
            case "pie":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(customerService.generateRentalPieChart(
                                "Rentals by months",
                                customerService.rentMoviesByMonths(year)));

        }

        return ResponseEntity.ok(customerService.rentMoviesByMonths(year));
    }
}
