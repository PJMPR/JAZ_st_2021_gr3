package org.example.caching.Providers;

import org.example.model.Dictionary;

import java.io.FileNotFoundException;
import java.util.List;

public class DataBaseProvider implements DataProvider{
    @Override
    public List<Dictionary> provide() throws FileNotFoundException {
        return null;
        //to implement
    }
}
