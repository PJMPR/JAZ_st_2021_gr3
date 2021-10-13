package org.example;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ObjectPropertyProvider {

    public List<Method> getPublicGetters(Class<?> clazz){
        List<Method> classGetters = new ArrayList<Method>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
         if(!void.class.equals(method.getReturnType()))
        {
            if(method.getParameterCount()==0)
             {
                if(Modifier.isPublic(method.getModifiers()))
                {
                    if(method.getName().startsWith("get") || method.getName().startsWith("is"))
                    {
                        classGetters.add(method);
                    }
                }
                }
            }
        }
        return classGetters;
    }


    public List<Method> getPublicSetters(Class<?> clazz){
        ArrayList<Method> list = new ArrayList<Method>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods)
        if(isSetter(method))
        list.add(method);
        return list;
    }

    public List<Method> getFieldsForPublicProperties(Class<?> clazz) {
        List<Method> classFields = new ArrayList<Method>();
         Method[] methods = clazz.getDeclaredMethods();
         for (Method method : methods)
         if (method.getName().startsWith("set") && method.getName().startsWith("get")) 
         {
            classFields.add(method);
         }
         
         return classFields;
 
}
}
