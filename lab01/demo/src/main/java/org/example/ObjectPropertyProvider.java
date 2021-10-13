package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){

        ArrayList<Method> mList = new ArrayList<>();
        Method[] methods = clazz.getMethods();

        for (Method method: methods) {
            if(Modifier.toString(method.getModifiers())=="public") {
                if (method.getName().startsWith("is") || method.getName().startsWith("get")) {
                    if(method.getParameterTypes().length == 0)
                    {
                        if(!void.class.equals(method.getReturnType()))
                        {
                            mList.add(method);
                        }
                    }
                }
            }
        }
        return mList.stream().toList();
        //return Arrays.stream(clazz.getDeclaredMethods()).toList();

    }


    public List<Method> getPublicSetters(Class<?> clazz){

        ArrayList<Method> mList = new ArrayList<>();
        Method[] methods = clazz.getMethods();

        for (Method method: methods) {
            if(Modifier.toString(method.getModifiers())=="public") {
                if (method.getName().startsWith("set")) {
                    if(method.getParameterTypes().length == 1)
                    {
                        if(void.class.equals(method.getReturnType()))
                        {
                            mList.add(method);
                        }
                    }
                }
            }
        }
        return mList.stream().toList();
        //return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){

        List<> setterList = 
        ArrayList<Method> mList = new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
            if(Modifier.toString(method.getModifiers())=="public") {
                if (method.getName().startsWith("is") || method.getName().startsWith("get")||method.getName().startsWith("set")) {
                    if(method.getParameterTypes().length == 0||method.getParameterTypes().length == 1)
                    {
                        if(!void.class.equals(method.getReturnType())||void.class.equals(method.getReturnType()))
                        {
                            if(method.getName().contains())
                            mList.add(method);
                        }
                    }
                }
            }
        }
        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
