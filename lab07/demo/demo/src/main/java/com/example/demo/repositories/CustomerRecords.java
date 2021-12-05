package com.example.demo.repositories;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.List;

public class CustomerRecords {
    public record CustomerEntry(int id, String firstName, String lastName) { }

    public record DatasetEntry(String key, Number value) {
        public static DefaultKeyedValues<String> toKeyedValues(List<DatasetEntry> list) {
            var keyedValues = new DefaultKeyedValues<String>();
            list.forEach(entry -> keyedValues.addValue(entry.key(), entry.value()));
            return keyedValues;
        }

        public static CategoryDataset toCategoryDataset(List<DatasetEntry> list) {
            var categoryDataset = new DefaultCategoryDataset();
            list.forEach(entry -> categoryDataset.addValue(entry.value().doubleValue(), "Value", entry.key()));
            return categoryDataset;
        }
    }

    public interface CustomerRankingBySpentMoneyEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        BigDecimal getSpent();

        static List<DatasetEntry> toDatasetEntryList(List<CustomerRankingBySpentMoneyEntry> list) {
            return list.stream()
                .map(entry -> new DatasetEntry("%s %s".formatted(entry.getCustomer().firstName(), entry.getCustomer().lastName()), entry.getSpent()))
                .toList();
        }
    }

    public interface CustomerRankingByWatchedMoviesEntry {
        @Value("#{new com.example.demo.repositories.CustomerRecords.CustomerEntry(target.customer_id, target.first_name, target.last_name)}")
        CustomerEntry getCustomer();
        short getWatched();

        static List<DatasetEntry> toDatasetEntryList(List<CustomerRankingByWatchedMoviesEntry> list) {
            return list.stream()
                    .map(entry -> new DatasetEntry("%s %s".formatted(entry.getCustomer().firstName(), entry.getCustomer().lastName()), entry.getWatched()))
                    .toList();
        }
    }

    public interface MonthRentActivityEntry {
        short getMonth();
        int getRentMovies();

        static List<DatasetEntry> toDatasetEntryList(List<MonthRentActivityEntry> list) {
            return list.stream()
                    .map(entry -> new DatasetEntry(new DateFormatSymbols().getMonths()[entry.getMonth()], entry.getRentMovies()))
                    .toList();
        }
    }

    public interface MonthIncomeEntry {
        short getMonth();
        int getIncome();

        static List<DatasetEntry> toDatasetEntryList(List<MonthIncomeEntry> list) {
            return list.stream()
                    .map(entry -> new DatasetEntry(new DateFormatSymbols().getMonths()[entry.getMonth()], entry.getIncome()))
                    .toList();
        }
    }
}

