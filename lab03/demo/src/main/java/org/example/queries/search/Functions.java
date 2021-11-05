package org.example.queries.search;

import org.example.model.Person;
import org.example.queries.results.Results;

import java.util.ArrayList;
import java.util.Objects;

public class Functions {
    private String For;
    private final Results person;

    public Functions(Results personArrayList, String task) {
        this.person = personArrayList;
    }


    public int Do(Funcs funcs){
        switch (funcs){
            case AVERAGE -> {
               return average();
            }
            case SUM -> {
               return sum();
            }
        }
        return 1;
    }
    public int sum(){
        int age = 0;
        for (Person person: person.getItems()) {
            if(Objects.equals(For, "Age")){
                age += person.getAge();
            }else {
                age += person.getIncome();
            }
        }
        return age;
    }

    public int average(){
        return sum()/person.getItems().size();
    }
}
