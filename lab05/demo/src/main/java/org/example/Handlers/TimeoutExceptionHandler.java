package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Actions;
import org.example.Provider;

import java.util.concurrent.TimeoutException;


public class TimeoutExceptionHandler implements Handler {
    Actions actions = new Actions();
    private final Logger logger = Logger.getLogger(TimeoutExceptionHandler.class.getName());

    @Override
    public String info() {
        return "TimeoutException";
    }

    @Override
    public boolean canHandle(Throwable e) {
        return  e instanceof TimeoutException;


    }

    @Override
    public boolean execute(Exception e, Provider metohod) {
        if (canHandle(e)) {
            System.out.println("Connection timed out");
            actions.wait(15);
            if (actions.tryAgain(metohod,10)){
               return true;
            }
            System.out.println(info());
            logger.error(info());
        }
        return  false;
    }

    @Override
    public void log() {
        logger.error(info());
    }
}