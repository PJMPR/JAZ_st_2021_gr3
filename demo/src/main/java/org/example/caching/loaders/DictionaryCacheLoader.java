package org.example.caching.loaders;

import org.example.caching.Cache;

import java.util.List;
import java.util.stream.Collectors;

public class DictionaryCacheLoader {
    List<DataProvider> dataProviders = List.of(
            new DataLoaderFromCSV()
    );
    public void load(){
        dataProviders.stream()
                .flatMap(dataProvider -> dataProvider.loadData().stream()).collect(Collectors.toList())
                .forEach(dictionary -> Cache.getInstance().add("dictionaries", dictionary));
    }
}
