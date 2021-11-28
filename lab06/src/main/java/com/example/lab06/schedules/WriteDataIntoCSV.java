package com.example.lab06.schedules;

import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDataIntoCSV implements Exporter{

    public void csvExport(Credit credit, TimeTable timeTable) throws IllegalAccessException, IOException {
        try (ICSVWriter writer = new CSVWriterBuilder(
                    new FileWriter("src/Credit.csv"))
                    .withSeparator(';')
                    .build()) {
            writer.writeAll(create(credit, timeTable));
        }
    }
}