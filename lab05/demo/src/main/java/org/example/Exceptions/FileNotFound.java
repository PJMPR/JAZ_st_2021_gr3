package org.example.Exceptions;

import org.example.Invoker;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class FileNotFound implements ErrorInterface{

    private final Logger logger = Logger.getLogger(FileNotFound.class.getName());

    @Override
    public String getMessage() {
        return "File not found exception";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof FileNotFoundException;
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
