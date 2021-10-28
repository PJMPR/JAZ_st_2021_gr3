package org.example;


import org.example.validators.Validator;

import java.lang.reflect.Field;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println("adam@wp.pl".matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));

        Sample sample = new Sample();
        sample.name="";
        Field field = Sample.class.getDeclaredField("name");
        System.out.println(field.get(sample)==null);
        new Validator().validate(new Sample());
        new Validator().validate(new Object());
    }
}



class Sample{ String name;}