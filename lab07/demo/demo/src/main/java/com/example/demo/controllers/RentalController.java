package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.interfaces.MonthIncomeEntry;
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
@RequestMapping("rental")
public class RentalController {
    private final CustomerRepository repository;

    public RentalController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("incomeByMonth")
    public ResponseEntity<List<MonthIncomeEntry>> incomeByMonth(HttpServletResponse response, @RequestParam("chart") final Optional<String> chart, @RequestParam("year") final Optional<Integer> year) throws IOException {
        final var list = year.isPresent() ? repository.getMonthIncomeForYear(year.get()) : repository.getMonthIncome();

        if (chart.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ChartMaker.export(chart.get(), response, MonthIncomeEntry.toDatasetEntryList(list), "Income by month.");
        return null;
    }

    @GetMapping("income")
    public ResponseEntity<List<MonthIncomeEntry>> income(HttpServletResponse response, @RequestParam("from") final String from, @RequestParam("to") final String to, @RequestParam("chart") final Optional<String> chart) throws IOException {
        final var list = repository.getIncomeForRange(from, to);

        if (chart.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ChartMaker.export(chart.get(), response, MonthIncomeEntry.toDatasetEntryList(list), "Income.");
        return null;
    }
}
