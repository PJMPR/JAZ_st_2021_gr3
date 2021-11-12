package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.providers.DictionaryCacheProvider;
import org.example.caching.providers.DictionaryFileProvider;
import org.example.model.Dictionary;

import java.util.List;

public class DictionaryCacheLoader implements CacheLoader {
    Cache cache = Cache.getInstance();

    public DictionaryFileProvider dictionaryFileProvider;

    @Override
    public void load(){
        DictionaryFileProvider dictionaryFileProvider = new DictionaryFileProvider();
        List<Dictionary> ItemList = dictionaryFileProvider.provideItems();
        String filePath = dictionaryFileProvider.filePath();

        System.out.println("");

        for(Dictionary item : ItemList){
            cache.add(dictionaryFileProvider.filePath(), item);
        }

    }
}
