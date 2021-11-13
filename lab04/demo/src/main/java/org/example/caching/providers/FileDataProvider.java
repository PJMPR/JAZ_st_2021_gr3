package org.example.caching.providers;

import org.example.model.Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataProvider implements DataProvider {

    private List<Dictionary> data() throws FileNotFoundException {
        String filePath = "src/dictionaries.csv";
        Scanner scanner = new Scanner(new File(filePath));
        List<Dictionary> dictionaryList = new ArrayList<>();
        Dictionary dictionary = new Dictionary();

        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(",");

            dictionary.setId(Integer.parseInt(strings[0]));
            dictionary.setIntKey(Integer.parseInt(strings[1]));
            dictionary.setStringKey(strings[2]);
            dictionary.setValue(strings[3]);
            dictionary.setDictionaryName(strings[4]);

            dictionaryList.add(new Dictionary(
                    dictionary.getId(),
                    dictionary.getIntKey(),
                    dictionary.getStringKey(),
                    dictionary.getValue(),
                    dictionary.getDictionaryName()));
        }
        return dictionaryList;
    }

    public List<Dictionary> dataProviderList() throws FileNotFoundException {
        return data();
    }
}
