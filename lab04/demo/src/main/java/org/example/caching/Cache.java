package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cache {

    public static Cache cache;
    private final List<CachedItem> items = new ArrayList<>();

    public static Cache getInstance() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }


    public <T> void putData(String key, T item) {
        items.add(new CachedItem(key, item));
    }


    @SuppressWarnings("unchecked")
    public <T> T getData(String key, Class<T> clazz) {
        return (T) items.stream()
                .filter(item -> Objects.equals(item.getKey(), key))
                .findAny()
                .get()
                .getValue();
    }

    public Object getData(String key) {
        return items.stream()
                .filter(item -> Objects.equals(item.getKey(), key))
                .map(CachedItem::getKey)
                .findAny().get();
    }
}
