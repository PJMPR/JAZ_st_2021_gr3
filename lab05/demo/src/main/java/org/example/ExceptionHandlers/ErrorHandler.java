package org.example.ExceptionHandlers;

import org.example.Logger;
import org.example.Supplier;

public interface ErrorHandler {

    ActionsUsedByHandlers actions = new ActionsUsedByHandlers();
    Logger logger = new Logger();

    String getMessage();

    Boolean canHandle(Exception e);

    void whatNow(Supplier method) throws Exception;

    default void handle(Supplier method, Exception err) throws Exception {
        if (canHandle(err)) {
            System.out.println(getMessage());
            logger.log(getMessage(), err);
            whatNow(method);
        }
    }
}
