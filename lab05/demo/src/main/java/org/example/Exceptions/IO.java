package org.example.Exceptions;

import org.apache.log4j.Logger;
import org.example.Invoker;

import java.io.IOException;

public class IO implements ErrorInterface{

    private final Logger logger = Logger.getLogger(IO.class.getName());

    @Override
    public String getMessage() {
        return "Input/output exception";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof IOException;
    }

    @Override
    public boolean handle(Exception exception, Invoker method) {
        if(canHandle(exception)){
            System.out.println(getMessage());
            log();
            return true;
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}
