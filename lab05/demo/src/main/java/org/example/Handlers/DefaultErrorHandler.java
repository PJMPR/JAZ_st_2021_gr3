package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider;

public class DefaultErrorHandler implements Handler{
    private final Logger logger = Logger.getLogger(DefaultErrorHandler.class.getName());
    private boolean canHandle = true;

    @Override
    public String info() {
        return "Unknown error";
    }

    @Override
    public boolean canHandle(Throwable e) {
        return canHandle;
    }

    @Override
    public static boolean execute(Exception e, Provider method) {

        System.out.println(info());
        log();
        return true;
    }

    @Override
    public void log() {
        logger.error(info());

    }
}
