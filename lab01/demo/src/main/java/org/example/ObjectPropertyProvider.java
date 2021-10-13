package org.example;


import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz) {

        List <Method> listOfMethods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List <Method> listOfGetters = null;
        for (Method method : listOfMethods){
            if(method.getName().contains("get") || method.getName().contains("is")){
                listOfGetters.add(method);
            }
        }

        return listOfGetters;
      //  return Arrays.stream(clazz.getDeclaredMethods()).toList();
        //ma wyciagnac tylko medoty ktore sa getterami
        // 1 -publiczna metoda
        // 2 - gete nie przyjmuje parametrów
        // 3 - getter cos zwraca nie moze byc void
    }


    public List<Method> getPublicSetters(Class<?> clazz){

        List <Method> listOfMethods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List <Method> listOfSetters = null;
        for (Method method : listOfMethods){
            if(method.getName().contains("set")){
                listOfSetters.add(method);
            }
        }

        return listOfSetters;


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){

        return Arrays.stream(clazz.getDeclaredFields()).toList();
        // z klasy chcemy wyłuskać wszystkie pola pod które są getery i setery


    }


}
