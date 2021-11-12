package org.example.caching.loaders;

import java.io.FileNotFoundException;

public interface CacheLoader {
    void load() throws FileNotFoundException;
}
