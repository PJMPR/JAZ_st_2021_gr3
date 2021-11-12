package org.example.caching.loaders;

import java.util.List;
import org.example.model.Dictionary;
import org.example.caching.Cache;
import org.example.caching.providers.DictionaryFileProvider;

public class DictionaryCacheLoader implements CacheLoader {
    Cache cache = Cache.getInstance();

    @Override
    public void load() {
        DictionaryFileProvider provider = new DictionaryFileProvider();
        List<Dictionary> ItemList = provider.provideItems();

        for (Dictionary item : ItemList) {
            cache.add(provider.getFile(), item);
        }
    }
}