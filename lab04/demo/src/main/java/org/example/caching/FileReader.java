package org.example.caching;

import org.example.model.Dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public List<Dictionary> giveItems() throws IOException {
        return readFile();
    }

    private static List<Dictionary> readFile() throws IOException {
        File path = new File("src/main/java/org/example/data/dictionaries.csv");
        List<Dictionary> dictionaries = new ArrayList<>();

        if(path.exists()){
            BufferedReader bufferedReader = Files.newBufferedReader(path.toPath());
            String record = bufferedReader.readLine();
            while (record != null) {
                List<String> elements = new ArrayList<>(Arrays.asList(record.split(",")));
                Dictionary item = makeRecord(elements);
                dictionaries.add(item);
                record = bufferedReader.readLine();
            }
        }
        return dictionaries;
    }
    public String getFileName() {
        File file = new File("src/main/java/org/example/data/dictionaries.csv");
        return file.getName().replaceFirst("[.][^.]+$", "");
    }

    private static Dictionary makeRecord(List<String> elements){
        return new Dictionary(Integer.parseInt(elements.get(0)), Integer.parseInt(elements.get(1)), elements.get(2), elements.get(3), elements.get(4));
    }
}
