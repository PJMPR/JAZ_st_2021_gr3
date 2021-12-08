package com.example.lab06.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class Bar {

    private final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

    public File generateBar(String chartTitle, String categoryAxis, String valueAxis) throws IOException {
        JFreeChart chart = ChartFactory.createBarChart(
                chartTitle,
                categoryAxis,
                valueAxis,
                defaultCategoryDataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        File barChart = new File("barChart.jpg");
        ChartUtils.saveChartAsJPEG(barChart, chart, 600, 400);

        return barChart;
    }

    public DefaultCategoryDataset getCategoryDataset(){
        return defaultCategoryDataset;
    }
}
