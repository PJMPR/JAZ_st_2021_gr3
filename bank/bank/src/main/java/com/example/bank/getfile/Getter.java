package com.example.bank.getfile;

import com.example.bank.model.Credit;
import com.example.bank.model.Timetable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface Getter {
    default List<String[]> getData(Credit credit, Timetable timetable) throws IllegalAccessException {

        List<String> creditFields = new ArrayList<>();
        List<String> creditValues = new ArrayList<>();

        List<String> timetableFields = new ArrayList<>();
        List<String> timetableValues = new ArrayList<>();

        for (Field field : credit.getClass().getDeclaredFields()) {
            creditFields.add(field.getName());
            creditValues.add(field.get(credit).toString());
        }

        for (Field field : timetable.getClass().getDeclaredFields()) {
            timetableFields.add(field.getName());
            timetableValues.add(field.get(credit).toString());
        }

        List<String[]> list = new ArrayList<>();
        list.add(creditFields.toArray(new String[0]));
        list.add(creditValues.toArray(new String[0]));
        list.add(timetableFields.toArray(new String[1]));
        list.add(timetableValues.toArray(new String[1]));
        return list;
    }
}
