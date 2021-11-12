package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataProvider {
    List<Dictionary> provide() throws FileNotFoundException;
}
