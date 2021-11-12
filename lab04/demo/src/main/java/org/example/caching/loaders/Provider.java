package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.util.List;

public interface Provider {
    List<Dictionary> providedList();
    String file();
}
