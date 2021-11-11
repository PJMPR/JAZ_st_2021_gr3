package org.example.caching;

import org.example.caching.loaders.DictionaryCacheLoader;

public class CacheItem {
    String key;
    Object value;
    long creationTime;
    long timeToLive = 180000; //3 minutes

    public CacheItem(String key, Object value, long creationTime) {
        this.key = key;
        this.value = value;
        this.creationTime = creationTime;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void checkIfExpired() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - creationTime;
        if (timeElapsed > timeToLive) {
            Cache.getInstance().items.clear();  //it could be better but ...
        } else {
            new DictionaryCacheLoader().load();
        }
    }
}
