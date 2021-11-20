package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider;

import java.util.concurrent.TimeUnit;

public abstract class LoggerOperations implements ErrorHandler{
    private final Logger logger;

    public LoggerOperations(Class<?> clazz){
        logger = Logger.getLogger(clazz);
    }

    public void response(Exception exception){
        System.out.println(message());
        logger.error(message(), exception);
    }

    public static boolean retry(Provider method, int howMany, int millis) {
        for (int i = 0; i < howMany; i++) {
            try {
                method.execute();
                return false;
            } catch (Exception exception) {
                wait(TimeUnit.MILLISECONDS, millis);
            }
        }
        return true;
    }

    public static void wait(TimeUnit timeUnit, int number) {
        try {
            timeUnit.sleep(number);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}