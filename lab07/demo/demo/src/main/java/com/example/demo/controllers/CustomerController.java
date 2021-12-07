package com.example.demo.controllers;

import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.model.YearRents;
import com.example.demo.repositories.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerDTO>> giveTopTenCustomersBySpentMoney(){
        return ResponseEntity.ok(customerService.setCustomers().stream()
                .sorted(Comparator.comparing(CustomerDTO::getSpent).reversed())
                .limit(10).collect(Collectors.toList()));
    }

    @GetMapping("customers/ranking/byWatchedMovies")
    public ResponseEntity<List<CustomerDTO>> giveTopTenCustomersByWatchedMovies(){
        return ResponseEntity.ok(customerService.setCustomers().stream()
                .sorted(Comparator.comparing(CustomerDTO::getWatched).reversed())
                .limit(10).collect(Collectors.toList()));
    }

    @GetMapping("customers/activity/rentMoviesByMonth/{year}/{id}")
    public YearRents getRentMoviesByYear(@PathVariable String year, @PathVariable String id){
        return customerService.getRentsByMonth(customerService.setCustomers().get(Integer.parseInt(id)), Integer.parseInt(year));
    }
}
