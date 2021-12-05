package com.example.demo.controllers;

import com.example.demo.repositories.records.DatasetEntry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public enum ChartMaker {
    PIE((dataset, title) -> ChartFactory.createPieChart(title, new DefaultPieDataset<>(DatasetEntry.toKeyedValues(dataset)), true, true, true)),
    BAR((dataset, title) -> ChartFactory.createBarChart(title, title, title, DatasetEntry.toCategoryDataset(dataset), PlotOrientation.VERTICAL,true,true,false)),
    LINEAR(((dataset, title) -> ChartFactory.createLineChart(title, title, title, DatasetEntry.toCategoryDataset(dataset))));

    final private Exporter exporter;

    ChartMaker(Exporter exporter) {
        this.exporter = exporter;
    }

    public Exporter getExporter() {
        return this.exporter;
    }

    public static void export(String exporter, HttpServletResponse response, List<DatasetEntry> dataset, String title) throws IOException {
        JFreeChart chart = ChartMaker.valueOf(exporter.toUpperCase()).exporter.export(dataset, title);
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
        response.flushBuffer();
    }
}
