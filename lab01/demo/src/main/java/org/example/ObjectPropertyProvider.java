package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ObjectPropertyProvider {

    // Wynikiem metody ma być lista stworzona z metod które są getterami
    public List<Method> getPublicGetters(Class<?> clazz){
        // Stwórz metode "m" która składa się z tablicy clazz.getDeclaratedMethods
        // Method m = Arrays.stream(clazz.getDeclaredMethods()).findFirst().or(null).get();
        List<Method> methodArray = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List<Method> finalMethodArray = new ArrayList<>();

        System.out.println("Number of methods: " + clazz.getDeclaredMethods().length);
        for(int i = 0 ; i < clazz.getDeclaredMethods().length ; i++){
            if(     methodArray.get(i).getName().contains("get") ||
                    methodArray.get(i).getName().contains("is") ||
                    methodArray.get(i).getParameterTypes().length == 0){
                finalMethodArray.add(methodArray.get(i));
                System.out.println("Saved method: " + methodArray.get(i).getName());
            }
        }
        return finalMethodArray;
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        List<Method> methodArray = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List<Method> finalMethodArray = new ArrayList<>();

        System.out.println("Number of methods: " + clazz.getDeclaredMethods().length);
        for(int i = 0 ; i < clazz.getDeclaredMethods().length ; i++){
            if(     methodArray.get(i).getName().contains("set") ||
                    methodArray.get(i).getParameterTypes().length == 1){
                finalMethodArray.add(methodArray.get(i));
                System.out.println("Saved method: " + methodArray.get(i).getName());
            }
        }
        return finalMethodArray;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        List<Method> methodArray = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List<Field> fieldList = new ArrayList<>();
        for (int i = 0 ; i < clazz.getFields().length ; i++){
        }
        return fieldList;
    }
}

