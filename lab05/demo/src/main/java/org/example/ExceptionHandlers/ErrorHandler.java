package org.example.ExceptionHandlers;

public interface ErrorHandler {

    ActionsInvokeByHandlers actionsInvokeByHandlers = new ActionsInvokeByHandlers();

    default String getMessage() {
        return null;
    }

    default Boolean canHandle(Exception e){
        return false;
    }

    default void whatNow(Object objOfMethod, String method){

    }

    default void handle(Object objOfMethod, Exception err, String methodName){
        if (canHandle(err)) {
            System.out.println(getMessage());
            whatNow(objOfMethod, methodName);
        }
    }
}
