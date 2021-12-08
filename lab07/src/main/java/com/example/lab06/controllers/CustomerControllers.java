package com.example.lab06.controllers;

import com.example.lab06.charts.ChartType;
import com.example.lab06.data.Payment;
import com.example.lab06.repository.CustomerRepository;
import com.example.lab06.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerControllers {

    CustomerRepository customerRepository;
    CustomerService customerService;

    @Autowired
    public CustomerControllers(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping
    @RequestMapping("/ranking/bySpentMoney")
    public ResponseEntity getTenCustomersRankingBySpentMoney(){
        return ResponseEntity.ok(customerService.getCustomersByMoneySpent(10));
    }

    @GetMapping
    @RequestMapping("/ranking/bySpentMoney/chart")
    public ResponseEntity getTenCustomersRankingBySpentMoneyChart() throws IOException {

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(customerService.makeChart(ChartType.PIE));
    }

    @GetMapping
    @RequestMapping("/ranking/byWatchedMovies")
    public ResponseEntity getTenCustomersRankingByWatchedMovies(){
        return ResponseEntity.ok(customerService.getCustomersByWatchedMovies(10));
    }

    @GetMapping
    @RequestMapping("/ranking/byWatchedMovies/chart")
    public ResponseEntity getTenCustomersRankingByWatchedMoviesChart() throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(customerService.makeChart(ChartType.BAR));
    }

    @GetMapping
    @RequestMapping("/activity/rentMoviesByMonth/{year}")
    public ResponseEntity getCustomersActivityByRentMoviesAndYearOverYear(@PathVariable("year") int year){
        return null;
    }

    @GetMapping
    @RequestMapping("/activity/rentMoviesByMonth/chart/{year}")
    public ResponseEntity getCustomersActivityByRentMoviesAndYearOverYearChart(@PathVariable("year") int year) throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(customerService.makeChart(ChartType.LINEAR));
    }

    @GetMapping
    @RequestMapping("/activity/rentMoviesByMonth/customerId/{id}")
    public ResponseEntity getCustomerActivity(@PathVariable("id") int id){
        return ResponseEntity.ok(customerRepository.getById(id).getPaymentList().stream()
                .map(Payment::getLastUpdate).collect(Collectors.toList()));
    }
}
