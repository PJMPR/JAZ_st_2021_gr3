package com.example.lab06.services;

import com.example.lab06.charts.Bar;
import com.example.lab06.charts.ChartType;
import com.example.lab06.charts.Linear;
import com.example.lab06.charts.Pie;
import com.example.lab06.data.Customer;
import com.example.lab06.rankings.Ranking;
import com.example.lab06.repository.CustomerRepository;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Ranking getCustomersByMoneySpent(int limit){
        List<Customer> customerList = customerRepository.findAll();
        List<Customer> customerList1 = customerList.stream().sorted((c2,c1) ->
                        Double.compare(c1.getAmountSpent(), c2.getAmountSpent()))
                .limit(limit).collect(Collectors.toList());
        Ranking ranking = new Ranking(new ArrayList<>());
        customerList1.forEach(ranking::addToRanking);
        return ranking;
    }

    public Ranking getCustomersByWatchedMovies(int limit){
        List<Customer> customerList = customerRepository.findAll();
        List<Customer> customerList1 = customerList.stream().sorted((c2,c1) ->
                        Double.compare(c1.getWatchedMovies(), c2.getWatchedMovies()))
                .limit(limit).collect(Collectors.toList());
        Ranking ranking = new Ranking(new ArrayList<>());
        customerList1.forEach(ranking::addToRanking);
        return ranking;
    }

    public Ranking getMonthIncome(){
        Ranking ranking = new Ranking(new ArrayList<>());
        return ranking;
    }

    public File makeChart(ChartType chartType) throws IOException {
        if(chartType == ChartType.BAR){
            Bar bar = new Bar();
            DefaultCategoryDataset defaultCategoryDataset = bar.getCategoryDataset();
            Ranking ranking = getCustomersByWatchedMovies(10);
            ranking.getCustomerList().forEach(customer -> defaultCategoryDataset.setValue((Number) customer.getWatchedMovies(),
                    customer.getCustomerId(), "Customers"));
            return bar.generateBar("Customers_By_Watched_Movies", "", "Watched_Movies");
        }
        else if(chartType == ChartType.PIE){
            Pie pie = new Pie();
            DefaultPieDataset defaultPieDataset = pie.getPieDataset();
            Ranking ranking = getCustomersByMoneySpent(10);
            ranking.getCustomerList().forEach(customer -> defaultPieDataset.setValue(customer.getCustomerId(), customer.getAmountSpent()));
            return pie.generatePie("Customers_By_Money_Spent");
        }
        else if(chartType == ChartType.LINEAR){
            Linear linear = new Linear();
            DefaultCategoryDataset defaultCategoryDataset = linear.getLinearDataset();
            Ranking ranking = getMonthIncome();
            ranking.getCustomerList().forEach(customer -> defaultCategoryDataset.setValue());
            return linear.generate("Month_Income","", " ","");
        }
        return null;
    }
}
