package org.example.caching.Providers;

import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataProvider {
    List<Dictionary> provide() throws FileNotFoundException;
}
