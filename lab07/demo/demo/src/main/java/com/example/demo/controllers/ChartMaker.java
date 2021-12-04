package com.example.demo.controllers;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.PieDataset;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

interface Exporter {
    void export(HttpServletResponse response, AbstractDataset dataset, String title) throws IOException;
}

public enum ChartMaker {
    PIE((response, dataset, title) -> {
        JFreeChart pieChart = ChartFactory.createPieChart(title, (PieDataset<?>) dataset, true, true, true);
        ChartUtils.writeChartAsPNG(response.getOutputStream(), pieChart, 800, 600);
        response.flushBuffer();
    }),
    BAR((response, dataset, title) -> {
        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                "",
                title,
                (DefaultCategoryDataset) dataset,
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

    public void export(HttpServletResponse response, AbstractDataset dataset, String title) throws IOException {
        this.exporter.export(response, dataset, title);
    }
}
