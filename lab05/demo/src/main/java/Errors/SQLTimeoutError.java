package Errors;

import java.sql.SQLTimeoutException;

public class SQLTimeoutError implements ErrorHandler {
    @Override
    public String getMessage() {
        return "Connection to the database failed";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof SQLTimeoutException;
    }

    @Override
    public void handle(Exception e, ExceptionThrower target) {
        if (canHandle(e)) {
            if (Retry.retry(target, 4, 3000)) {
                System.out.println(getMessage());
                logger.loggerError(getMessage(), e);
            }
        }

    }
}
