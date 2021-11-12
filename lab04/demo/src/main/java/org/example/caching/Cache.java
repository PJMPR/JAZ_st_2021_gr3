package org.example.caching;
import org.example.model.CachedItem;

import java.util.ArrayList;
import java.util.List;

public enum Cache {
    INSTANCE;

    private final List<CachedItem> cachedItems = new ArrayList<>();

    public static Cache getInstance(){
        return INSTANCE;
    }


    public <T> void add(String key, T item){
       cachedItems.add(new CachedItem(key,item));
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz){
        return (T) cachedItems.stream()
                .filter( cachedItem -> cachedItem
                        .getKey().equals(key))
                        .findAny()
                        .get()
                        .getItem();
    }

    public Object get(String key){
        return cachedItems.stream()
                .filter( cachedItem -> cachedItem.
                        getKey()
                        .equals(key))
                        .findAny()
                        .get()
                        .getItem();
    }
    public void clear(){
        cachedItems.clear();
    }

}
