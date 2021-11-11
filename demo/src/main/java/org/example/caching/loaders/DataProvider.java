package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.util.List;

public interface DataProvider {
    List<Dictionary> loadData();
}
