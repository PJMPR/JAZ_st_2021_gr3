package org.example.caching.providers;

import java.util.List;
import org.example.model.Dictionary;

public interface DictionaryCacheProvider {
    List<Dictionary> provideItems();
}