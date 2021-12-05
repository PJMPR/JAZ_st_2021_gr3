package com.example.demo.controllers;

import com.example.demo.repositories.records.DatasetEntry;
import org.jfree.chart.JFreeChart;

import java.io.IOException;
import java.util.List;

public interface Exporter {
    JFreeChart export(List<DatasetEntry> dataset, String title) throws IOException;
}
