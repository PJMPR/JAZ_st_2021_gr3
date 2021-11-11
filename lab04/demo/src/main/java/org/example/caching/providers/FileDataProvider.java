package org.example.caching.providers;

import org.example.model.Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public record FileDataProvider() implements DataProvider {

    //feature to load Dictionary type data from .csv file.
    private List<Dictionary> loadFromCsvFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/files/dictionaries.csv"));
        List<Dictionary> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] record = scanner.nextLine().split(",");
            list.add(new Dictionary(
                    Integer.parseInt(record[0]),
                    Integer.parseInt(record[1]),
                    record[2],
                    record[3],
                    record[4]
            ));
        }
        return list;
    }

    public List<Dictionary> provide() throws FileNotFoundException {
        return loadFromCsvFile();
    }
}
