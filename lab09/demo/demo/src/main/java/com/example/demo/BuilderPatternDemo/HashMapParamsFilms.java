package com.example.demo.BuilderPatternDemo;

import com.example.demo.model.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
@Setter
@Getter
@NoArgsConstructor
public class HashMapParamsFilms {
    private HashMap<String,Integer> integersValues;
    private HashMap<String,BigDecimal> bigDecimalValues;
    private String stringValue;
    private Language languageValue;

    public HashMapParamsFilms(Integer id, Integer page, Language language, String title,
                              Integer release_year, Integer rental_duration, BigDecimal rental_rate,
                              BigDecimal replacement_costs) {
        this.integersValues = new HashMap<>();
        this.bigDecimalValues = new HashMap<>();
        this.stringValue = title;
        this.languageValue = language;

        integersValues.put("page",page);
        integersValues.put("id",id);
        integersValues.put("releaseYear",release_year);
        integersValues.put("rentalDuration",rental_duration);

        bigDecimalValues.put("rentalRate",rental_rate);
        bigDecimalValues.put("replacementCost",replacement_costs);

    }

    public String findValue(String key) {

        if(integersValues.containsKey(key)){
            return integersValues.get(key).toString();
        }
        if(bigDecimalValues.containsKey(key)){
            return bigDecimalValues.get(key).toString();
        }
        if(key.equals("language")){
            return languageValue.getName();
        }
        if(key.equals("title")){
            return stringValue;
        }else {
            return "404";
        }
    }

    public void showAll() {
        System.out.println();
        System.out.println("INFO INFO INFO ");
        System.out.println(integersValues.entrySet());
        System.out.println(bigDecimalValues.entrySet());
        System.out.println("title = " + stringValue);
        System.out.println("INFO INFO INFO ");
        System.out.println();
    }
}

