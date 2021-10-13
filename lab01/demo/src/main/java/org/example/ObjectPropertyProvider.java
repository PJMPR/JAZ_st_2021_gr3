package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            if(isGetter(method)) System.out.println(method);;
        }
        return Arrays.stream(methods).toList();
    }

    public static boolean isGetter(Method method) {
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            if(isSetter(method)) System.out.println(method);
        }
        return Arrays.stream(methods).toList();
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }

    public static boolean isSetterField(Field field){
        if(!field.getName().startsWith("set")) return false;
        return true;
    }

    public static boolean isGetterField(Field field){
        if(!field.getName().startsWith("get")) return false;
        return true;
    }

    public List<Field> getFieldsForPublicProperties(Class<?> clazz){
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            if(isSetterField(field)) System.out.println(field);
            if(isGetterField(field)) System.out.println(field);
        }
        return Arrays.stream(fields).toList();

    }


}
