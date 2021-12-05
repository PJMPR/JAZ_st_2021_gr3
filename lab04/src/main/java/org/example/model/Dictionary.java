package org.example.model;

import com.opencsv.bean.CsvBindByPosition;

public class Dictionary {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private int intKey;
    @CsvBindByPosition(position = 2)
    private String stringKey;
    @CsvBindByPosition(position = 3)
    private String value;
    @CsvBindByPosition(position = 4)
    private String dictionaryName;

    public Dictionary() {
    }

    public Dictionary(int id, int intKey, String stringKey, String value, String dictionaryName) {
        this.id = id;
        this.intKey = intKey;
        this.stringKey = stringKey;
        this.value = value;
        this.dictionaryName = dictionaryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntKey() {
        return intKey;
    }

    public void setIntKey(int intKey) {
        this.intKey = intKey;
    }

    public String getStringKey() {
        return stringKey;
    }

    public void setStringKey(String stringKey) {
        this.stringKey = stringKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }
}
