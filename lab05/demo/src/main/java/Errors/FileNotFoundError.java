package Errors;

import java.io.FileNotFoundException;

public class FileNotFoundError implements ErrorHandler {
    @Override
    public String getMessage() {
        return "File not found";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof FileNotFoundException;
    }

    @Override
    public void handle(Exception e, ExceptionThrower target) {
        if (canHandle(e)) {
            System.out.println(getMessage());
            logger.loggerError(getMessage(), e);
        }
    }
}
