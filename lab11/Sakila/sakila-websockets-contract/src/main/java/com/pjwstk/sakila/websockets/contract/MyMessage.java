package com.pjwstk.sakila.websockets.contract;

public class MyMessage {

    private String name;
    private String message;

    public MyMessage() {
    }

    public MyMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
