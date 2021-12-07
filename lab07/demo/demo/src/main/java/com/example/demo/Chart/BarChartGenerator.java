package com.example.demo.Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.AbstractDataset;
import java.io.IOException;

public class BarChartGenerator extends ChartGenerator implements IChartGenerator{
    AbstractDataset dataset = new DefaultCategoryDataset();

    @Override
    public byte[] toGenerate(String title, String type, String xAxis, String yAxis) throws IOException {
        JFreeChart barChart = ChartFactory.createBarChart(title,xAxis,yAxis,(CategoryDataset) dataset,PlotOrientation.VERTICAL,true,true,false);

        return saveChart(title,barChart,type);
    }
}
