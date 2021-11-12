package org.example.caching;

public class CashItem {
    String key;
    Object volume;

    public CashItem(String key, Object volume) {
        this.key = key;
        this.volume = volume;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getVolume() {
        return volume;
    }

    public void setVolume(Object volume) {
        this.volume = volume;
    }
}
