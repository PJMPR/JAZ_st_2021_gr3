package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public class CustomerRecords {
    public record MonthCountEntry(int month, int count){}
    public record MonthIncomeEntry(int month, double income){}
    public record CustomerEntry(int id, String firstName, String lastName){}

    public interface CustomerRankingBySpentMoneyEntry{
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        BigDecimal getSpent();
    }

    public interface CustomerRankingByWatchedMoviesEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        short getWatched();
    }

    public interface MonthCountRankingEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.MonthCountEntry(target.month_number, target.count_in_month)}")
        MonthCountEntry getMonthCount();
    }

    public interface MonthIncomeRankingEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.MonthIncomeEntry(target.month_number, target.income_in_month)}")
        MonthIncomeEntry getMonthIncome();
    }
}
