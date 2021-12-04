package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
import com.example.demo.repositories.CustomerRepository;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
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
    public ResponseEntity<List<CustomerRecords.CustomerRankingBySpentMoneyEntry>> bySpentMoney(HttpServletResponse response, @RequestParam("chart") final Optional<String> chart) throws IOException {

        final var list = repository.get10CustomersByMostSpentMoney();

        if (chart.isPresent()) {
            if (chart.get().equals("pie")) {

                DefaultPieDataset<String> pieDataset = new DefaultPieDataset<>();

                for (var item : list) {
                    pieDataset.setValue(item.getCustomer().firstName() + " " + item.getCustomer().lastName(), item.getSpent().doubleValue());
                }

                ChartMaker.PIE.export(response, pieDataset, "By spent money");
            } else if (chart.get().equals("bar")) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                for (var item : list) {
                    dataset.setValue(item.getSpent().doubleValue(), item.getCustomer().firstName() + " " + item.getCustomer().lastName(), "users");
                }

                JFreeChart barChart = ChartFactory.createBarChart(
                        "bySpentMoney",
                        "users",
                        "bySpentMoney",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

                ChartUtils.writeChartAsPNG(response.getOutputStream(), barChart, 800, 600);
                response.flushBuffer();
            }
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("byWatchedMovies")
    public ResponseEntity<List<CustomerRecords.CustomerRankingByWatchedMoviesEntry>> byWatchedMovies(@RequestParam("chart") final Optional<String> chart) {
        return new ResponseEntity<>(repository.get10CustomersByMostMoviesWatched(), HttpStatus.OK);
    }
}
