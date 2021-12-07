package com.example.demo.services;


import com.example.demo.charts.BarChart;
import com.example.demo.charts.ChartTypes;
import com.example.demo.charts.LinearChart;
import com.example.demo.charts.PieChart;
import com.example.demo.data.Customer;
import com.example.demo.ranking.Ranking;
import com.example.demo.repos.CustomerRepo;

import com.example.demo.statistics.CustomerStatistics;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CustomerService {

    private CustomerRepo customerRepo;
    private Object ChartTypes;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo =customerRepo;
    }

    public Ranking getCustomersBySpentMoney(){
        List<Customer> customers = customerRepo.findAll();
        List<Customer> topTenCustomers = customers.stream()
                .sorted((c2,c1) -> Double.compare(c1.amountSpent(), c2.amountSpent()))
                .limit(10).collect(Collectors.toList());
        Ranking ranking = new Ranking(new ArrayList<>());
        topTenCustomers.forEach(ranking::addToRanking);
        return ranking;

    }
    public Ranking getCustomersByWatchedMovies() {
        List<Customer> customerList = customerRepo.findAll();
        List<Customer> topCustomersList = customerList.stream()
                .sorted((c2, c1) -> Double.compare(c1.moviesWatched(), c2.moviesWatched()))
                .limit(10).collect(Collectors.toList());
        Ranking ranking = new Ranking(new ArrayList<>());
        topCustomersList.forEach(ranking::addToRanking);
        return ranking;
    }

    public byte[] makeChart(ChartTypes chartTypes) throws IOException {

        switch (chartTypes){
            case BAR:
                BarChart barChart = new BarChart();
                DefaultCategoryDataset defaultCategoryDataset = barChart.getDefaultCategoryDataset();
                Ranking chartData = getCustomersByWatchedMovies();
                chartData.getCustomerRanking().forEach(customerWatchedMovies -> defaultCategoryDataset.setValue((Number) customerWatchedMovies.getWatchedMovies(), customerWatchedMovies.getCustomerId()));
                return barChart.generate("Customers By watched Movies", "smth", "watched movies");

            case PIE:
                PieChart pieChart = new PieChart();
                DefaultPieDataset defaultCategoryDataset1 = pieChart.getDefaultPieDataset();
                Ranking chartData1 = getCustomersBySpentMoney();
                chartData1.getCustomerRanking().forEach(customer -> defaultCategoryDataset1(customer.getCustomerId(), customer.getSpentMoney()));
                return barChart.generate("spent money by customers");

            case LINEAR:
                LinearChart linearChart = new LinearChart();

        }
    }




}
