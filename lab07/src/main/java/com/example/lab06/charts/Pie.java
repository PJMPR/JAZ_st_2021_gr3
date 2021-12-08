package com.example.lab06.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;
import java.io.IOException;

public class Pie {

    private final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();

    public File generatePie(String chartTitle) throws IOException {
        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle,
                defaultPieDataset,
                true,true,false
        );

        File pieChart = new File("pieChart.jpg");
        ChartUtils.saveChartAsJPEG(pieChart, chart, 600, 400);
        return pieChart;
    }

    public DefaultPieDataset getPieDataset(){
        return defaultPieDataset;
    }
}
