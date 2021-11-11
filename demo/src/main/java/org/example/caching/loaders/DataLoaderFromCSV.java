package org.example.caching.loaders;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.example.model.Dictionary;

public class DataLoaderFromCSV implements DataProvider{
    @Override
    public List<Dictionary> loadData() {
        List<Dictionary> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("..\\dictionaries.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                var test = Arrays.asList(line.split(","));
                list.add(new Dictionary(Integer.parseInt(test.get(0)),Integer.parseInt(test.get(1)), test.get(2), test.get(3), test.get(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
