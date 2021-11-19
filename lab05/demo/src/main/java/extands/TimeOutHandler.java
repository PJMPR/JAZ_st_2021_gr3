package extands;

import org.apache.log4j.Logger;
import org.example.Supplier;

import java.util.concurrent.TimeoutException;

public class TimeOutHandler implements ExtandHandler{
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());

    @Override
    public String getMessage() {
        return "Time out";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof TimeoutException;
    }

    @Override
    public void handle(Exception exception, Supplier method) throws InterruptedException {
        if (canHandle(exception)){
            System.out.println("Time out, reconnecting:");
            if (ReDo.redoWithDelay(method,3)){
                return;
            }
            System.out.println(getMessage());
            logger.error(getMessage());
        }
    }
}
