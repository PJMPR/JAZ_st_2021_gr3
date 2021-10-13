package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        //Method m = Arrays.stream(clazz.getDeclaredMethods()).findFirst().or(null).get();
        ArrayList<Method> myList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            if(Modifier.toString(method.getModifiers()) == "public"){
                if (method.getName().startsWith("get")||method.getName().startsWith("is")){
                    if(method.getParameterTypes().length == 0){
                        if(!void.class.equals(method.getReturnType())){
                            myList.add(method);
                        }
                    }
                }
            }

        }

        return myList.stream().toList();

    }


    public List<Method> getPublicSetters(Class<?> clazz){
        ArrayList<Method> myList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            if(Modifier.toString(method.getModifiers()) == "public"){
                if(method.getName().startsWith("set")){
                    if(method.getParameterTypes().length == 1){
                        if(void.class.equals(method.getReturnType())){
                            myList.add(method);
                        }
                    }
                }
            }
        }

        return myList.stream().toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        ArrayList<Method> myList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            if(Modifier.toString(method.getModifiers()) == "public"){
                if(method.getName().startsWith("set")||method.getName().startsWith("get")||method.getName().startsWith("is")){
                    if(method.getParameterTypes().length == 1||method.getParameterTypes().length == 0){
                        myList.add(method);
                    }
                }
            }
        }

        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
