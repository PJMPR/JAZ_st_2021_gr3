package org.example.caching;

import org.example.caching.loaders.CacheLoader;

import java.util.HashMap;
import java.util.List;

public class Cache extends HashMap<String, CashedItem> {
    private static final List<CacheLoader> loaders = List.of(CacheLoader.dictionaryCacheLoader);
    private static final Cache instance = new Cache();

    public static Cache getInstance() { return instance; }

    private Cache() {
        loaders.forEach(cacheLoader -> {
            try {
                this.putAll(cacheLoader.load());
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        });
    }

    public <T> void add(String key, T item) {
        put(key, new CashedItem(item));
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) getOrDefault(key, new CashedItem(null)).getValue();
    }

    public <T> T get(String key, Class<T> clazz) {
        return (T) clazz.cast(get(key));
    }
}
