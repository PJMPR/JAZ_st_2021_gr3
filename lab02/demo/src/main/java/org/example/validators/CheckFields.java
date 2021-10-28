package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckFields {
    private HashMap<String, List<String>> hashMap = new HashMap<>();

    public ArrayList<Field> returnOnlyNotNullFields(Field[] fields) {
        ArrayList<Field> notNullFields = new ArrayList<>();
        for (Field f: fields) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(NotNull.class)){
                notNullFields.add(f);
            }
        }
        return notNullFields;
    }

    public ArrayList<Field> returnOnlyregexFields(Field[] fields) {
        ArrayList<Field> regexFields = new ArrayList<>();
        for (Field f: fields) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(Regex.class)){
                regexFields.add(f);
            }
        }
        return regexFields;
    }


    public ArrayList<Field> returnOnlyRangeFields(Field[] fields)  {
        ArrayList<Field> rangeFields = new ArrayList<>();
        for (Field f: fields) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(Range.class)){
                rangeFields.add(f);
            }
        }
        return rangeFields;

    }




    public   Boolean checkNotNullFields(ArrayList<Field> notNullFields,Object object) throws IllegalAccessException {
        boolean isOkN = true;
        for (Field f : notNullFields) {
            if( f.get(object) == null){

                if(!hashMap.containsKey(f.getName())){
                    hashMap.put(f.getName(), new ArrayList<String>());
                }
                hashMap.get(f.getName()).add(f.getAnnotation(NotNull.class).message2());
                hashMap.get(f.getName()).add(f.getAnnotation(NotNull.class).message());

                isOkN = false;
            }
        }
        System.out.println("bolean notnull field " + isOkN);
        return isOkN;
    }




    public  Boolean checkRegexFields(ArrayList<Field> regexFields,Object object) throws IllegalAccessException {
        boolean isOkR = true;
        for (Field f : regexFields){
            if(!f.get(object).toString().matches(f.getAnnotation(Regex.class).pattern())){
                if(!hashMap.containsKey(f.getName())){
                    hashMap.put(f.getName(),new ArrayList<String>());
                }
                hashMap.get(f.getName()).add(f.getAnnotation(Regex.class).message());

                isOkR = false;

                System.out.println("bolean regex field " + isOkR);
            }
        }
        return isOkR;
    }

    public  Boolean checkRangeFields(ArrayList<Field> rangeFields,Object object) throws IllegalAccessException {
        boolean isOk = true;



        for (Field f : rangeFields){
            if(   !   ((int)f.get(object) > (int) f.getAnnotation(Range.class).min()
                    && (int) f.get(object) < (int) f.getAnnotation(Range.class).max()
            )){
                if(!hashMap.containsKey(f.getName())){
                    hashMap.put(f.getName(),new ArrayList<String>());
                }
                hashMap.get(f.getName()).add(f.getAnnotation(Range.class).message());
                isOk = false;
                System.out.println("bolean range field " + isOk);
            }
        }
        return isOk;
    }

    public HashMap<String, List<String>> returnHashMapWithInvalidFields() {
        return hashMap;
    }


}
