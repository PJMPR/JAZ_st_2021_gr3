package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProvide implements Provider{
     private List<Dictionary> dictionaryList= new ArrayList<>();
    @Override
    public void Provide() {
        Scanner scanner = new Scanner("src/Date/dictionaries.csv");
        while ( scanner.hasNextLine()){
            String[] item = scanner.nextLine().split(",");
            dictionaryList.add(new Dictionary(
                    Integer.parseInt(item[0]),
                    Integer.parseInt(item[1]),
                    item[2],
                    item[3],
                    item[4]));
        }
    }

    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }
}
