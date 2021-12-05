package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

interface Exporter {
    void export(HttpServletResponse response, List<CustomerRecords.DatasetEntry> dataset, String title) throws IOException;
}

public enum ChartMaker {
    PIE((response, dataset, title) -> {
        DefaultPieDataset<String> pieDataset = new DefaultPieDataset<>();

        for (var item : dataset) {
            pieDataset.setValue(item.key(), item.value());
        }

        JFreeChart pieChart = ChartFactory.createPieChart(title, pieDataset, true, true, true);
        ChartUtils.writeChartAsPNG(response.getOutputStream(), pieChart, 800, 600);
        response.flushBuffer();
    }),
    BAR((response, dataset, title) -> {
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();

        for (var item : dataset) {
            barDataset.setValue(item.value(), "Value", item.key());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                "",
                title,
                barDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartUtils.writeChartAsPNG(response.getOutputStream(), barChart, 800, 600);
        response.flushBuffer();
    });

    final private Exporter exporter;

    ChartMaker(Exporter exporter) {
        this.exporter = exporter;
    }

    public static void export(String exporter, HttpServletResponse response, List<CustomerRecords.DatasetEntry> dataset, String title) throws IOException {
        ChartMaker.valueOf(exporter.toUpperCase()).exporter.export(response, dataset, title);
    }
}
