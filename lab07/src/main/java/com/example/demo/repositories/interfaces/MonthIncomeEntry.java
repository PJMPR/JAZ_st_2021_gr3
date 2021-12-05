package com.example.demo.repositories.interfaces;

import com.example.demo.repositories.records.DatasetEntry;

import java.text.DateFormatSymbols;
import java.util.List;

public interface MonthIncomeEntry {
    short getMonth();
    int getIncome();

    static List<DatasetEntry> toDatasetEntryList(List<MonthIncomeEntry> list) {
        return list.stream()
                .map(entry -> new DatasetEntry(new DateFormatSymbols().getMonths()[entry.getMonth()], entry.getIncome()))
                .toList();
    }
}