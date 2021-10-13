package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("get") && method.getParameterTypes().length != 0 && void.class.equals(method.getReturnType())) {

            }
            else{

            }
        }
        return Arrays.stream(clazz.getDeclaredMethods()).toList();
    }


        public List<Method> getPublicSetters (Class < ? > clazz){

            return Arrays.stream(clazz.getDeclaredMethods()).toList();
        }


        public List<Field> getFieldsForPublicProperties (Class < ? > clazz){

            return Arrays.stream(clazz.getDeclaredFields()).toList();

        }

}
