package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cache {

    private final List<CacheItem> cacheItemList = new ArrayList<>();
    private static final Cache instance = new Cache();

    public static Cache getInstance(){
        return instance;
    }

    public <T> void add(String key, T item){
        cacheItemList.add(new CacheItem(key, item));
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) cacheItemList.stream().filter(cacheItem ->
                Objects.deepEquals(cacheItem.getKey(), key))
                .findAny().get().getItem();
    }

    public Object get(String key){
        return cacheItemList.stream().filter(cacheItem ->
                Objects.deepEquals(cacheItem.getKey(), key))
                .map(CacheItem::getItem)
                .collect(Collectors.toList());
    }
}
