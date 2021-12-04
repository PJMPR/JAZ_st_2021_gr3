package com.example.demo.repositories;


import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public class CustomerRecords {
    public record CustomerEntry(int id, String firstName, String lastName) { }

    public interface CustomerRankingBySpentMoneyEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        BigDecimal getSpent();
    }

    public interface CustomerRankingByWatchedMoviesEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        short getWatched();
    }

    public interface MonthRentActivityEntry {
        short getMonth();
        int getRentMovies();
    }

    public interface MonthIncomeEntry {
        short getMonth();
        int getIncome();
    }
}

