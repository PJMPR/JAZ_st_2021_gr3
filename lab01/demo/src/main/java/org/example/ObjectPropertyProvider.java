package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            if(isGetter(method)) System.out.println("getter: "+method);
        }

        return Arrays.stream(methods).toList();

    }
    public static boolean isGetter(Method method){
        if(method.getName().startsWith("get")) {return true;}
        else return false;
    }
    public static boolean isSetter(Method method){
        if(method.getName().startsWith("set")){return true;}
        else return false;
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        Method[] methods =clazz.getMethods();
        for(Method method:methods){
            if(isSetter(method)) System.out.println("setter: "+method);
        }

        return Arrays.stream(methods).toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields)
        {
            field.set();
        }


        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
