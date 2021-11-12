package org.example.caching.loaders;


import org.example.caching.Cache;
import org.example.model.Dictionary;
import org.example.model.DictiornaryFilesProvider;

import java.util.List;

public class DictionaryCacheLoader implements Loader{

 Cache cache = Cache.getInstance();


 public void load() {

  DictiornaryFilesProvider provider = new DictiornaryFilesProvider();
  List<Dictionary> records = provider.providedList();
  String file = provider.file();
  for (Dictionary record:
          records) {
   cache.add(file, record);
  }



 }
}
