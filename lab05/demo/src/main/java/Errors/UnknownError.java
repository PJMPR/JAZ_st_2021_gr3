package Errors;

public class UnknownError implements ErrorHandler {
    @Override
    public String getMessage() {
        return "Unknown error";
    }

    @Override
    public boolean canHandle(Exception e) {
        return true;
    }

    @Override
    public void handle(Exception e, ExceptionThrower target) {
        System.out.println(getMessage());
        logger.loggerError(getMessage(), e);
    }
}
