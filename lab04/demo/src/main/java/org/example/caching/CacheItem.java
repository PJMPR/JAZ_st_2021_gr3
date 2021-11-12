package org.example.caching;

public class CacheItem {
    public Object item;
    public String key;

    public CacheItem(){
        this.key=key;
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
