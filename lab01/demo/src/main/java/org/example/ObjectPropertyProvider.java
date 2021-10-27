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
/*
        List<Method> methods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        List<Method> result = new ArrayList<>();
        for (Method m : methods) {
            if(new SimpleMethod(m).isGetter())
                result.add(m);
        }
 */
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(m->new SimpleMethod(m).isGetter())
                .toList();
    }


    public List<Method> getPublicSetters(Class<?> clazz){

        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(m->new SimpleMethod(m).isSetter())
                .toList();
    }


    public List<Field> getFieldsForPublicProperties(Class<?> clazz){

        List<Method> props = getPublicGetters(clazz);
        props.addAll(getPublicSetters(clazz));

        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field->
                        props
                            .stream()
                            .map(p-> getFieldName(p))
                            .anyMatch(name-> namesMatch(field, name)))
                .toList();
    }

    private boolean namesMatch(Field field, String name) {
        return name
                .equals(field.getName()
                        .toLowerCase(Locale.ROOT));
    }

    private String getFieldName(Method p) {
        return new SimpleMethod(p).getFieldName()
                .toLowerCase(Locale.ROOT);
    }


    private class SimpleMethod {
        Method method;
        public SimpleMethod(Method m) {
            method = m;
        }

        public boolean isPublic() {
            return Modifier.isPublic(method.getModifiers());
        }

        public boolean startsWith(String prefix) {
            return method.getName().startsWith(prefix);
        }

        public boolean isVoid() {
            return method.getReturnType().equals(void.class);

        }

        public boolean hasParamsCount(int n) {
            return method.getParameterCount()==n;
        }

        public boolean isGetter(){
            return isPublic() && (startsWith("get")||startsWith("is"))
                    && !isVoid() && hasParamsCount(0);
        }

        public boolean isSetter(){
            return isPublic()
                    && startsWith("set")
                    && isVoid()
                    && hasParamsCount(1);
        }

        public String getFieldName(){
            if(startsWith("get") || startsWith("set"))
                return method.getName().substring(3);
            if(startsWith("is"))
                return method.getName().substring(2);
            return "";
        }
    }
}
