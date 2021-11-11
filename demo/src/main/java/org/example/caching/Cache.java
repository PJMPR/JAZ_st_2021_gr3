package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

    private static volatile Cache instance = null;
    List<CacheItem> items=new ArrayList<>();

    private Cache() {
        if(instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
    }

    public static Cache getInstance() {
        if(instance == null) {
            synchronized(Cache.class) {
                if(instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

    public <T> void add(String key, T item){
        items.add(new CacheItem(key, item, System.currentTimeMillis()));
    }

    public <T> T get(String key, Class<T> clazz){
        List<T> list = items.stream().filter(item -> item.getKey().equals(key)).map(item -> (T) item.getValue()).collect(Collectors.toList());
        return list.size() > 0 ? clazz.cast(list.get(0)) : (T) clazz.cast(list);
    }

    public Object get(String key){
        return items.stream().filter(item -> item.getKey().equals(key)).map(CacheItem::getValue).collect(Collectors.toList());
    }
}
