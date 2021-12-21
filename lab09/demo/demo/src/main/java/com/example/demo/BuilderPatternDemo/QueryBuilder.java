package com.example.demo.BuilderPatternDemo;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.services.LanguageService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class QueryBuilder  {
    @Autowired
    private LanguageService languageService;
    private int amountOfParamsInQuery = 0;
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
        System.out.println("QUERY = " + getQuery());

        query = "SELECT film FROM Film film ";
        amountOfParamsInQuery = 0;
    }

    public void prepareTitleQuery(String title) {
        amountOfParamsInQuery++;
        whereANDhandler(amountOfParamsInQuery);
        addToQuery("film.title LIKE '" +title +"%' ");

    }

    public void prepareQuery(String key, HashMapParamsFilms paramsMap) {
        amountOfParamsInQuery++;
        whereANDhandler(amountOfParamsInQuery);
        addToQuery("film." + key + " = " + paramsMap.findValue(key));
    }


    public void prepareLanguageQuery(String languageName) {
        amountOfParamsInQuery++;
        whereANDhandler(amountOfParamsInQuery);

        List<LanguageDto> list = languageService.getLanguagesBYName(languageName);

        int languageID = list.get(0).getId();
        addToQuery("film.language = "+languageID );

    }

    private void whereANDhandler(int amountOfParamsInQuery) {
        if(amountOfParamsInQuery > 1){
            addAND();
        }
        else {
            addWhere();
        }
    }
}
