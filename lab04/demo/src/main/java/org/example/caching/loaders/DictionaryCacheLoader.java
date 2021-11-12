package org.example.caching.loaders;
import org.example.caching.Cache;
import org.example.caching.LiveTimeChecker;
import org.example.caching.Providers.FileDataProvider;

import java.io.FileNotFoundException;


public class DictionaryCacheLoader implements CacheLoader, LiveTimeChecker {
    Cache cache  = Cache.getInstance();
    long createdTime;

    @Override
    public void load() throws FileNotFoundException {
        FileDataProvider fileDataProvider = new FileDataProvider();
            if (checkLiveTime(createdTime)){
                cache.clear();
            }
            this.createdTime = System.currentTimeMillis();
            cache.add(fileDataProvider.getKey(), fileDataProvider.provide());



    }

}
