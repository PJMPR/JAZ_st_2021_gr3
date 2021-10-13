package org.example;


public class Character {
    int race;
    int clase;
    int number;
    int height;
    String name;
    String status;

    public int getRace(){
        return race;
    }
    public int getClase(){
        return clase;
    }
    private int getNumber(){
        return number;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setName(String name){
        this.name = name;
    }
}