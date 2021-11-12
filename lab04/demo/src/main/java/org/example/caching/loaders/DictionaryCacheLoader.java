package org.example.caching.loaders;

import org.example.caching.CachedItem;

public class DictionaryCacheLoader implements CacheLoader {
    @Override
    public void load() throws NumberFormatException {
        new CachedItem("dictionaries", new FileDataProvider().provide());
    }
}
