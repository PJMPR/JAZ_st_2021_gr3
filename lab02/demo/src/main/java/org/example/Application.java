package org.example;


import java.lang.reflect.Field;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println("adam@wp.pl".matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));

        Sample obj = new Sample();
        obj.name="";
        Field f = Sample.class.getDeclaredField("name");
        System.out.println(
        f.get(obj)==null);
    }
}



class Sample{ String name;}