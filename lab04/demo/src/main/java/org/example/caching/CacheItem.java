package org.example.caching;

public class CacheItem {
    private final String key;
    private final Object item;

    public CacheItem(String key, Object item) {
        this.key = key;
        this.item = item;
    }

    public String getKey() {
        return key;
    }

    public Object getItem() {
        return item;
    }
}
