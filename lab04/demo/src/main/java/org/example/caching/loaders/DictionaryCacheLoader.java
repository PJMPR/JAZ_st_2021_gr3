package org.example.caching.loaders;

import org.example.caching.CashItem;

public class DictionaryCacheLoader implements Loader{

    public void load( ){
        FileProvide provide = new FileProvide();
        provide.Provide();
        new CashItem("dictionaries",provide.getDictionaryList());

    }
}
