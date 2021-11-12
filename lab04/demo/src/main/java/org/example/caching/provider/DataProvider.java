package org.example.caching.provider;

import org.example.model.Dictionary;

import java.util.List;

public interface DataProvider {
    List<Dictionary> provider();
}
