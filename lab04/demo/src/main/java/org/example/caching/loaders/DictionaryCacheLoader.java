package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.providers.DataProvider;
import org.example.caching.providers.FileDataProvider;
import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryCacheLoader implements CacheLoader{

    private final Cache cache = Cache.getInstance();
    private final List<DataProvider> dataProviderList = List.of(new FileDataProvider());

    public void load(){
        List<Dictionary> dictionaryList = new ArrayList<>();
        dataProviderList.forEach(dataProvider -> {
            try {
                dictionaryList.addAll(dataProvider.dataProviderList());
                cache.add("dictionaries", dictionaryList);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
    }
}
