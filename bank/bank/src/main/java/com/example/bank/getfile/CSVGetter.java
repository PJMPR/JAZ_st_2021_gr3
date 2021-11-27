package com.example.bank.getfile;

import com.example.bank.model.Credit;
import com.example.bank.model.Timetable;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSVGetter implements Getter {
    public void getFile(Credit credit, Timetable timetable) throws IOException, IllegalAccessException {
        try (ICSVWriter csvmaker = new CSVWriterBuilder(
                new FileWriter("src/files/CSV.csv"))
                .withSeparator(',')
                .build()) {
            csvmaker.writeAll(getData(credit, timetable));
        }
    }
}
