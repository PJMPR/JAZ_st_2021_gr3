package com.example.demo.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class PieChart {
    private final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();

    public PieChart(){}

    public DefaultPieDataset getDefaultPieDataset(){
        return getDefaultPieDataset();
    }

    public byte[] generate(String tittle) throws IOException {
        JFreeChart chart = ChartFactory.createPieChart(
                tittle,
                defaultPieDataset,
                true,
                true,
                false
        );
        File chartBar = new File(tittle+"_pieChat.jpeg");
        ChartUtils.saveChartAsJPEG(chartBar, chart, 550,400);
        BufferedImage bufferedImage = ImageIO.read(new File(tittle+"_pieChat.jpeg"));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
