package org.example.caching.providers;

import org.example.model.Dictionary;

import java.util.List;

public interface DictionaryCacheProvider {
    List<Dictionary> provideItems();
}
