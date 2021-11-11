package org.example.caching;

public class ItemMap {

    // Map value and key
    public String key;
    public Object item;

    // Constructor
    public ItemMap(String key, Object item) {
        this.key = key;
        this.item = item;
    }

    // Getters
    public String getKey() {
        return key;
    }

    public Object getItem() {
        return item;
    }
}
