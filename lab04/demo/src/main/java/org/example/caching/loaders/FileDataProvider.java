package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataProvider implements DataProvider {

    private List<Dictionary> loadFile() throws NumberFormatException {
        List<Dictionary> dictionary = new ArrayList<>();
        Scanner scanner = new Scanner("dictionaries.csv");
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            dictionary.add(new Dictionary(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3],
                    data[4]));

        }
        return dictionary;
    }

    @Override
    public List<Dictionary> provide() {
        return loadFile();
    }
}
