package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        //Method m = Arrays.stream(clazz.getDeclaredMethods()).findFirst().or(null).get();
        ArrayList methodsList = new ArrayList();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            if (Modifier.toString(method.getModifiers()) == "public"){
                if (method.getName().startsWith("get") || method.getName().startsWith("is")){
                    if (method.getParameterTypes().length == 0){
                        if (!void.class.equals(method.getReturnType()))
                            methodsList.add(method);
                    }
                }
            }
        }

        //return Arrays.stream(clazz.getDeclaredMethods()).toList();
        return methodsList.stream().toList();
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        ArrayList methodsList = new ArrayList();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            if (Modifier.toString(method.getModifiers()) == "public"){
                if (method.getName().startsWith("set")){
                    if (method.getParameterTypes().length == 1){
                        if (void.class.equals(method.getReturnType()))
                            methodsList.add(method);
                    }
                }
            }
        }

        return methodsList.stream().toList();
        //return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        ArrayList fieldList = new ArrayList();

        List<Method> getterList = getPublicGetters(clazz);
        List<Method> setterList = getPublicSetters(clazz);

        Field[] fields = clazz.getDeclaredFields();
        boolean isInList = false;
        for (Field field:fields) {
            for (Method method:getterList) {
                if (method.getName().toLowerCase(Locale.ROOT).contains(field.getName().toLowerCase(Locale.ROOT))){
                    isInList = true;
                }
            }
            for (Method method:setterList) {
                if (method.getName().toLowerCase(Locale.ROOT).contains(field.getName().toLowerCase(Locale.ROOT))){
                    isInList = true;
                }
            }

            if (isInList)
                fieldList.add(field);

            isInList=false;
        }
        return fieldList.stream().toList();
        //return Arrays.stream(clazz.getDeclaredFields()).toList();

    }

}
