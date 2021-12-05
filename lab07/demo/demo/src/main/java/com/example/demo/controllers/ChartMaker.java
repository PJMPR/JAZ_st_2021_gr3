package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRecords;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

interface Exporter {
    JFreeChart export(List<CustomerRecords.DatasetEntry> dataset, String title) throws IOException;
}

public enum ChartMaker {
    PIE((dataset, title) -> ChartFactory.createPieChart(title, new DefaultPieDataset<>(CustomerRecords.DatasetEntry.toKeyedValues(dataset)), true, true, true)),
    BAR((dataset, title) -> ChartFactory.createBarChart(title, title, title, CustomerRecords.DatasetEntry.toCategoryDataset(dataset), PlotOrientation.VERTICAL,true,true,false)),
    LINEAR(((dataset, title) -> ChartFactory.createLineChart(title, title, title, CustomerRecords.DatasetEntry.toCategoryDataset(dataset))));

    final private Exporter exporter;

    ChartMaker(Exporter exporter) {
        this.exporter = exporter;
    }

    private static void flush(JFreeChart chart, HttpServletResponse response) throws IOException {
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
        response.flushBuffer();
    }

    public static void export(String exporter, HttpServletResponse response, List<CustomerRecords.DatasetEntry> dataset, String title) throws IOException {
        JFreeChart chart = ChartMaker.valueOf(exporter.toUpperCase()).exporter.export(dataset, title);
        ChartMaker.flush(chart, response);
    }
}
