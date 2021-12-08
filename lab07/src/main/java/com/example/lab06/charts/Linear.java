package com.example.lab06.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class Linear {
    private final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

    public File generate(String tittle, String type, String xLabel, String yLabel) throws IOException{
        JFreeChart chart = ChartFactory.createLineChart(
                tittle,
                xLabel,
                yLabel,
                defaultCategoryDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        File linearChart = new File("linearChart.jpg");
        ChartUtils.saveChartAsJPEG(linearChart, chart, 600, 400);

        return linearChart;
    }

    public DefaultCategoryDataset getLinearDataset() {
        return defaultCategoryDataset;
    }
}
