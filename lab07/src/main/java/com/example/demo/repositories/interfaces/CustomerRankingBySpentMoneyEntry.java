package com.example.demo.repositories.interfaces;

import com.example.demo.repositories.records.CustomerEntry;
import com.example.demo.repositories.records.DatasetEntry;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.List;

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
