package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {
    private static final Cache cache = new Cache();
    private List<CacheItem> cacheItems = new ArrayList<>();


    public static Cache getInstance() {
        return new Cache();
    }


    public <T> void add(String key, T item) {
        CacheItem cache = new CacheItem();
        cache.key = key;
        cache.item = item;
        cacheItems.add(cache);

    }

    public <T> T get(String key, Class<T> clazz) {
        return (T) cacheItems.stream()
                .filter(element ->
                        key.equals(element.key) && clazz.equals(element.item.getClass()))
                .findAny()
                .get()
                .item;
    }

    public Object get(String key) {
        return cacheItems.stream()
                .filter(cacheItem -> key.equals(cacheItem.key))
                .map(cacheItem -> cacheItem.item)
                .collect(Collectors.toList());
    }
}
