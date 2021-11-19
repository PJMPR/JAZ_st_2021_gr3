import Errors.UnknownError;
import Errors.*;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

public class SafeInvoker {
    private final List<ErrorHandler> errorHandlers = List.of(
            new FileNotFoundError(),
            new SQLInvalidAuthError(),
            new SQLTimeoutError()
    );

    public void invoke(ExceptionThrower exceptionThrower) {
        String log4jPath = "src/main/java/Logs/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        try {
            exceptionThrower.throwException();
        } catch (Exception e) {
            findErrorHandler(e).handle(e, exceptionThrower);
        }
    }

    public ErrorHandler findErrorHandler(Exception e) {
        return errorHandlers.stream()
                .filter(errorHandler -> errorHandler.canHandle(e))
                .findAny().orElse(new UnknownError());
    }
}
