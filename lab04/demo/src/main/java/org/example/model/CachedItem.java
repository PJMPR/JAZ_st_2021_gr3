package org.example.model;

public class CachedItem<T> {

    private final T item;
    private final String key;

    public CachedItem(String key, T item) {
        this.key = key;
        this.item = item;
    }

    public String getKey() {
        return key;
    }

    public T getItem(){
        return item;
    }
}