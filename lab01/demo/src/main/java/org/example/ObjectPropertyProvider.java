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

        List<Method> setterList = getPublicGetters(clazz);
        List<Method> getterList = getPublicSetters(clazz);
        ArrayList<Field> mList = new ArrayList<>();
        Field[] fields = clazz.getFields();
        boolean isInField = false;
        for (Field field:fields
             ) {
            for (Method method: setterList
                 ) {
                if(method.getName().toLowerCase(Locale.ROOT).contains(field.getName().toLowerCase(Locale.ROOT))){
                    isInField = true;
                }


            }

            for (Method method: getterList
            ) {
                if(method.getName().toLowerCase(Locale.ROOT).contains(field.getName().toLowerCase(Locale.ROOT))){
                    isInField = true;
                }


            }
            if(isInField)
            {
                mList.add(field);
            }
            isInField = false;
        }

        return Arrays.stream(clazz.getDeclaredFields()).toList();

    }


}
