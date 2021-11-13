package org.example.caching.providers;

import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataProvider {
    List<Dictionary> dataProviderList() throws FileNotFoundException;
}
