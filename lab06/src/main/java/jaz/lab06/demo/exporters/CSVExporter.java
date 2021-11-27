package jaz.lab06.demo.exporters;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import jaz.lab06.demo.credit.Credit;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter implements Exporter{

    public void createCSV(Credit credit) throws IOException, IllegalAccessException {

        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter("src/main/resources/generatedCSV.csv"))
                .withSeparator(';')
                .build()) {
            writer.writeAll(createSimpleData(credit));
        }
    }
}