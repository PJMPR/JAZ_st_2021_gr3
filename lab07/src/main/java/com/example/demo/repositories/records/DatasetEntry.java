package com.example.demo.repositories.records;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

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
