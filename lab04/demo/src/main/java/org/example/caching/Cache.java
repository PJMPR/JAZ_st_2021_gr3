package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cache {
        static Cache instance = new Cache();
        private List<CacheItem> cacheItemList = new ArrayList<>();

        public static Cache getInstance(){
            if(instance==null){
                instance = new Cache();
            }
            return instance;
    }


    public <T> void add(String key, T item){
        cacheItemList.add(new CacheItem(item, key));

    }

    public <T> T get(String key, Class<T> clazz){
        return (T) cacheItemList.stream().filter(cacheItem -> Objects.equals(cacheItem.getKey(),key)).findAny().get().getItem();
    }

    public Object get(String key){
        return cacheItemList.stream().filter(cacheItem -> key.equals(cacheItem.getKey())).map(cacheItem -> cacheItem.getItem()).collect(Collectors.toList());

    }
}
