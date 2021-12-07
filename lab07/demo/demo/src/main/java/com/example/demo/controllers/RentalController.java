package com.example.demo.controllers;

import com.example.demo.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Rental")
public class RentalController {

    RentalService rs;

    @Autowired
    public RentalController(RentalService rs) {
        this.rs = rs;
    }

    @GetMapping
    @RequestMapping("/incomeByMonth/{year}")
    public ResponseEntity getIncomeByMonth(@PathVariable int year) {
        return ResponseEntity.ok(rs.getIncomeByYear(year));
    }

    @GetMapping
    @RequestMapping("/income/{from}/{to}")
    public ResponseEntity getIncomeFromTo(@PathVariable String from, @PathVariable String to) {
        return ResponseEntity.ok(rs.gerIncomeFromTo(from, to));
    }

    @GetMapping
    @RequestMapping("/incomeByMonth.jpg/{chart}/{year}")
    public ResponseEntity getIncomeByMonth(@PathVariable int year, @PathVariable String chart) throws IOException {
        switch (chart) {
            case "linear":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rs.generateRentalLinearChart(
                                "Income by month",
                                "Months",
                                "Income",
                                rs.getIncomeByYear(year)));
            case "bar":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rs.generateRentalBarChart(
                                "Income by month",
                                "Months",
                                "Income",
                                rs.getIncomeByYear(year)));
            case "pie":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rs.generateRentalPieChart(
                                "Income by month",
                                rs.getIncomeByYear(year)));
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
}
