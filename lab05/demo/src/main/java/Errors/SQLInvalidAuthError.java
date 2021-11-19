package Errors;

import java.sql.SQLInvalidAuthorizationSpecException;

public class SQLInvalidAuthError implements ErrorHandler {
    @Override
    public String getMessage() {
        return "Invalid authorization";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof SQLInvalidAuthorizationSpecException;
    }

    @Override
    public void handle(Exception e, ExceptionThrower target) {
        if (canHandle(e)) {
            System.out.println(getMessage());
            logger.loggerError(getMessage(), e);
        }
    }
}
