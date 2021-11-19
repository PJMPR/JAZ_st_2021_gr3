package Errors;

import Logger.Logger;

public interface ErrorHandler {
    Logger logger = new Logger();

    String getMessage();

    boolean canHandle(Exception e);

    void handle(Exception e, ExceptionThrower target);

}
