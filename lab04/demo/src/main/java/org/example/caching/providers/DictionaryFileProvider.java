package org.example.caching.providers;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.example.model.Dictionary;

public class DictionaryFileProvider implements DictionaryCacheProvider {
    @Override
    public List<Dictionary> provideItems() {
        return readFile();
    }

    private static Dictionary createItem(String[] element) {
        return new Dictionary(Integer.parseInt(element[0]), Integer.parseInt(element[1]), element[2], element[3], element[4]);
    }

    public String getFile() {
        File file = new File("../dictionaries.csv");
        return file.getName().replaceFirst("[.][^.]+$", "");
    }

    private static List<Dictionary> readFile() {
        String filePath = "../dictionaries.csv";
        List<Dictionary> elementsInDictionary = new ArrayList<>();
        Path pathToFile = Paths.get(filePath);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Dictionary item = createItem(attributes);
                elementsInDictionary.add(item);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementsInDictionary;
    }
}