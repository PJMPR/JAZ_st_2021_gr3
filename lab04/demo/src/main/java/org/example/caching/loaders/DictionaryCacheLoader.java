package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.FileReader;
import org.example.model.Dictionary;

import java.io.IOException;
import java.util.List;

public class DictionaryCacheLoader {

    Cache cache = Cache.getInstance();

    public void load() throws IOException {
        FileReader reader = new FileReader();
        List<Dictionary> list = reader.giveItems();
        for  (Dictionary dictionary : list){
            cache.add(reader.getFileName(), dictionary);
        }
    }
}
