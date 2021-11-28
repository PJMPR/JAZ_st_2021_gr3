package com.example.lab06.schedules;

import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface Exporter {
    default List<String[]> create(Credit credit, TimeTable timeTable) throws IllegalAccessException {

        List<String> fields = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for(Field field : credit.getClass().getDeclaredFields()){
            fields.add(field.getName());
            values.add(field.get(credit).toString());
        }

        for(Field field : timeTable.getClass().getDeclaredFields()){
            fields.add(field.getName());
            values.add(field.get(credit).toString());
        }

        List<String[]> list = new ArrayList<>();
        list.add(fields.toArray(new String[0]));
        list.add(values.toArray(new String[0]));
        return list;
    }
}
