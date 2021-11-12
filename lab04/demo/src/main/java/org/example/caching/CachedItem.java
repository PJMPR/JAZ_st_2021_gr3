package org.example.caching;

public class CachedItem<T> {

    private final String key;
    private final T value;

    public CachedItem(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
