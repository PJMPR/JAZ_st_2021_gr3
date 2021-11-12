package org.example.caching;

import java.util.List;

public class Cache {
    public static Cache instance;
    List<CashItem> cashItemList;

    public static Cache getInstance(){
        if(instance==null){
            instance = new Cache();
        }
        return instance;

    }

    private Cache(){

    }
    public <T> void add(String key, T item){
        cashItemList.add(new CashItem(key,item));
    }

    public <T> T get(String key, Class<T> clazz){

        return (T) clazz.cast(new Object());
    }

    public Object get(String key){
        return cashItemList.stream()
                .filter(cashItem -> cashItem.getKey()==key);
    }
}
