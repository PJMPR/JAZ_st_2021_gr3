package com.example.demo.repositories.interfaces;

import com.example.demo.repositories.records.DatasetEntry;

import java.text.DateFormatSymbols;
import java.util.List;

public interface MonthRentActivityEntry {
    short getMonth();
    int getRentMovies();

    static List<DatasetEntry> toDatasetEntryList(List<MonthRentActivityEntry> list) {
        return list.stream()
                .map(entry -> new DatasetEntry(new DateFormatSymbols().getMonths()[entry.getMonth()], entry.getRentMovies()))
                .toList();
    }
}
