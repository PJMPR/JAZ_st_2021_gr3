package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cache {

    private static Cache instance = new Cache();
    private final List<CacheItem> cache = new ArrayList<>();


    public static Cache getInstance(){
        return instance;
    }


    public <T> void add(String key, T item){
        cache.add(new CacheItem(item, key));
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) cache.stream()
                .filter(cachesItem -> Objects
                .equals(cachesItem.getKey(), key))
                .findAny()
                .get()
                .getItem();
    }

    public Object get(String key){
        return cache.stream()
                .filter(cacheItem -> key
                .equals(cacheItem.key))
                .map(cacheItem -> cacheItem.item)
                .collect(Collectors.toList());
    }
}
