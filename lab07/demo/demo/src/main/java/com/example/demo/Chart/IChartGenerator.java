package com.example.demo.Chart;

import org.jfree.data.general.AbstractDataset;
import java.io.IOException;

public interface IChartGenerator {
    byte[] toGenerate(String title,String type,String xAxis,String yAxis) throws IOException;
    AbstractDataset getDataSet;
}
