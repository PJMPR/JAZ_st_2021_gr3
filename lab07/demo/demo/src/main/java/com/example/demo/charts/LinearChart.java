package com.example.demo.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class LinearChart {
    private final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

    public LinearChart(){
    }

    public DefaultCategoryDataset getDefaultCategoryDataset(){
        return defaultCategoryDataset;
    }

    public byte[] generate(String tittle, String type, String xLabel, String yLabel) throws IOException{
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
        File linearChart = new File(tittle+"_linearChart.jpeg");
        ChartUtils.saveChartAsJPEG(linearChart, chart, 550,400);
        BufferedImage bufferedImage = ImageIO.read(new File(tittle+"_linearChart.jpeg"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
