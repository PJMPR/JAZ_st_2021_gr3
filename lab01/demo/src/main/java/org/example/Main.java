package org.example;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;



public class Main {

    public static void main(String[] args){

        Class<?> clazz = FooService.class;

        System.out.println(clazz.getName());

        System.out.println(clazz.getSimpleName());

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getDeclaringClass().equals(clazz))
                System.out.println(method.getName());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field :
                fields) {
            System.out.println(field.getName());
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor cc :
                constructors) {
            System.out.println(cc.getName());
            for (Class<?> c :
                    cc.getParameterTypes()) {
                System.out.println(c.getSimpleName());
            }
        }


        try {
            Constructor constructor = clazz.getConstructor(new Class[]{Main.class, String.class});

            FooService foo = (FooService) constructor.newInstance(new Main(),"adam");
            System.out.println(foo.hello());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    class FooService{

        String name;
        boolean isTrue;

        public FooService(){}

        public FooService(String name){
            this.name=name;
        }

        public String hello(){
            return "Hello " + name;
        }

    }

}
