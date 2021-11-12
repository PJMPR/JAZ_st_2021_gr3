package org.example.model;

public class CachedItem <T>{
   private final String key;
   private final T item;

    public CachedItem(String key, T item) {
        this.key = key;
        this.item = item;
    }

    public String getKey(){
        return key;
    }
    public T getItem(){
        return item;
    }
}
