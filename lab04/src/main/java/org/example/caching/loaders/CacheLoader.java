package org.example.caching.loaders;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.caching.CashedItem;
import org.example.model.Dictionary;

import java.io.FileReader;
import java.util.Map;

public interface CacheLoader {
    Map<String, CashedItem> load() throws Exception;

    CacheLoader dictionaryCacheLoader = () -> Map.of(
            "dictionaries",
            new CashedItem(new CsvToBeanBuilder<Dictionary>(new FileReader("dictionaries.csv")).withType(Dictionary.class).build().parse())
    );
}
