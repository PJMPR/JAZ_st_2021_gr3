package com.example.demo.contract;

public class Genre {
    private int id;
    private String name;

    public Genre(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
