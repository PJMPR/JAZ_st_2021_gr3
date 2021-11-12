package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {
    private static final Cache instance = new Cache();
    private final List<CacheItem> cacheItemList = new ArrayList<>();

    public static Cache getInstance(){
        return instance;
    }

    public <T> void add(String key, T item){
        cacheItemList.add(new CacheItem(key,item));
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) cacheItemList.stream()
                .filter(item -> key.equals(item.getKey())
                        && clazz.equals(item.getItem().getClass()))
                .findAny().get().getItem();
    }

    public Object get(String key){
        return cacheItemList.stream()
                .filter(cacheItem -> cacheItem.getKey().equals(key))
                .findAny().get().getItem();
    }
}
