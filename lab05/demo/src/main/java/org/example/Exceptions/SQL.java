package org.example.Exceptions;

import org.apache.log4j.Logger;
import org.example.Invoker;
import org.example.Repeater;

import java.sql.SQLException;

public class SQL implements ErrorInterface{

    private final Logger logger = Logger.getLogger(SQL.class.getName());

    @Override
    public String getMessage() {
        return "SQL exception";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof SQLException;
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
