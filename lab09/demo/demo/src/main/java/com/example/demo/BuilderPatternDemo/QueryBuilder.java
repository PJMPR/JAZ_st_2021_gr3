package com.example.demo.BuilderPatternDemo;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class QueryBuilder  {
    private String query = "SELECT film FROM Film film ";
    private final String AND = "AND ";


    public void addToQuery(String s) {
        query = getQuery() + s + " " ;
    }
    public void addAND(){
        query = getQuery() + "AND ";
    }
    public void addWhere(){
        query = getQuery() + "WHERE ";
    }

    public void clear() {
        query = "SELECT film FROM Film film ";
    }
}
