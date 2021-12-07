package com.example.demo.Chart;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public abstract class ChartGenerator {
    public byte[] saveChart(String title,JFreeChart chart,String type)throws IOException{
        File fileWithChart = new File(title + type + ".jpeg");
        ChartUtilities.saveChartAsJPEG(fileWithChart,chart,600,600);
        BufferedImage bufferedImage =ImageIO.read(new File(title + type + ".jpeg"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }
}
