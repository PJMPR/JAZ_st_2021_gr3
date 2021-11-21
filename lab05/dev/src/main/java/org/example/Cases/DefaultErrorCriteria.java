package org.example.Cases;
import org.apache.log4j.Logger;
import org.example.Provider;

public class DefaultErrorCriteria implements CriteriaInterface {
    private final Logger logger = Logger.getLogger(DefaultErrorCriteria.class.getName());
    private boolean canHandle = true;

    @Override
    public String info() {
        return "Unknown error.";
    }

    @Override
    public boolean canHandle(Exception e) {
        return canHandle;
    }

    @Override
    public boolean handle(Exception e, Provider method) {
        System.out.println(info());
        log();
        return true;
    }

    @Override
    public void log() {
        logger.error(info());
    }

}