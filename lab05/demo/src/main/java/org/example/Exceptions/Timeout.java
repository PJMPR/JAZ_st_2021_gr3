package org.example.Exceptions;

import org.example.Invoker;

import java.util.concurrent.TimeoutException;
import org.apache.log4j.Logger;
import org.example.Repeater;

public class Timeout implements ErrorInterface{

    private final Logger logger = Logger.getLogger(Timeout.class.getName());

    @Override
    public String getMessage() {
        return "Timeout";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof TimeoutException;
    }

    @Override
    public boolean handle(Exception exception, Invoker method) throws InterruptedException {
        if(canHandle(exception)){
            if(Repeater.repeater(method, 3)){
                return true;
            }
            System.out.println(getMessage());
            log();
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}
