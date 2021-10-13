package org.example;

public class Application {

    public static void main(String[] args){
        ObjectPropertyProvider test= new ObjectPropertyProvider();
        for (int i = 0; i < test.getPublicGetters(Character.class).size(); i++) {
            System.out.println(test.getPublicGetters(Character.class).get(i));
        }
    }
}

