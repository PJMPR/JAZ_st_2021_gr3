package org.example.caching.Providers;

import org.example.model.Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileDataProvider implements DataProvider{
    String key = "dictionaries";

    private List<Dictionary> loadFromFile() throws FileNotFoundException {
        String path = "src/files/dictionaries.csv";

        Scanner scanner = new Scanner(new File(path));
        List<Dictionary> listFromFile = new ArrayList<>();
        while (scanner.hasNext()){
            String[] words = scanner.nextLine().split(",");
            listFromFile.add(
                    new Dictionary(
                            Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                            words[2], words[3], words[4]));
        }
        return listFromFile;
    }
    public String getKey() {
        return key;
    }

    @Override
    public List<Dictionary> provide() throws FileNotFoundException {
        return loadFromFile();
    }
}
