package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider;
import org.xml.sax.ErrorHandler;

import java.io.FileNotFoundException;


public class FileNotFoundHandler implements Handler {
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());


    @Override
    public String info() {
        return "File not found";
    }

    @Override
    public boolean canHandle(Throwable e) {
        return e instanceof FileNotFoundException;
    }

    @Override
    public boolean execute(Exception e, Provider method) {
        if (canHandle(e)) {
            System.out.println(info());
            log();
            return true;
        }
        return false;
    }


    @Override
    public void log() {
        logger.error(info());


    }
}
