package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        List<Method> listOfGetters = new ArrayList<Method>();

        for (Method method : methods) {
            if (Modifier.toString(method.getModifiers()).equals("Public")){
                if(method.getName().contains("get")||method.getName().contains("is")){
                    listOfGetters.add(method);
                }
            }
        }
        return listOfGetters;
    }

    public List<Method> getPublicSetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        List<Method> listOfSetters = new ArrayList<Method>();

        for (Method method : methods) {
            if (Modifier.toString(method.getModifiers()).equals("Public")){
                if(method.getName().contains("set")){
                    listOfSetters.add(method);
                }
            }
        }
        return listOfSetters;
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
    }
}
