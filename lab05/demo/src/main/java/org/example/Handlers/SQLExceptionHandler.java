package org.example.Handlers;

import org.example.Actions;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.example.Provider;

public class SQLExceptionHandler implements Handler {
    Actions actions = new Actions();
    private final Logger logger = Logger.getLogger(SQLExceptionHandler.class.getName());

    @Override
    public String info() {
        return "Attempt failed";
    }

    @Override
    public boolean canHandle(Throwable e) {
        return e instanceof SQLException;
    }

    @Override
    public boolean execute(Exception e, Provider metohod) {
        if (canHandle(e)){
            System.out.println("Trying to recconect to database");
            actions.wait(5);
            if (actions.tryAgain(metohod,3)){
                return true;
            }
            System.out.println(info());
            log();

        }
        return false;
    }

    @Override
    public void log() {
        logger.error(info());
    }
}
