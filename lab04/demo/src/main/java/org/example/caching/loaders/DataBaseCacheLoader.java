package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.LiveTimeChecker;

import java.io.FileNotFoundException;

public class DataBaseCacheLoader implements CacheLoader, LiveTimeChecker {
    long createdTime;
    Cache cache;

    @Override
    public void load() throws FileNotFoundException {
        if (checkLiveTime(createdTime) || createdTime !=0) {
            cache.clear();
        }

            this.createdTime = System.currentTimeMillis();
            this.cache = Cache.getInstance();
            // to future implement..
    }

}
