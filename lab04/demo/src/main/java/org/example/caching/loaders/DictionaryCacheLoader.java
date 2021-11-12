package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.provider.DataProvider;
import org.example.caching.provider.FileDataProvider;
import org.example.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryCacheLoader implements CacheLoader{
    private final Cache cache = Cache.getInstance();
    private final List<DataProvider> dataProviders = List.of(new FileDataProvider());


    @Override
    public void load() {
        List<Dictionary> dictionaries = new ArrayList<>();
        dataProviders.stream().forEach(cacheProvider -> dictionaries.addAll(cacheProvider.provider()));
        cache.add("dictionaries", dictionaries);
    }
}
