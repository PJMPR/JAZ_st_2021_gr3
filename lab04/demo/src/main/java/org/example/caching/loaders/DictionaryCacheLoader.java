package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.providers.DataProvider;
import org.example.caching.providers.FileDataProvider;
import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryCacheLoader implements CacheLoader{

    Cache cache = Cache.getInstance();
    List<DataProvider> providers = List.of(
            new FileDataProvider()
    );

    public void load(){
        List<Dictionary> itemList = new ArrayList<>();
        try {
            for(DataProvider provider: providers){
             itemList.addAll(provider.provide());
            }
            cache.add("dictionaries", itemList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
