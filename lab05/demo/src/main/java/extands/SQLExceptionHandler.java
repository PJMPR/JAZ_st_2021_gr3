package extands;

import org.apache.log4j.Logger;
import org.example.Supplier;

import java.sql.SQLException;

public class SQLExceptionHandler implements ExtandHandler{
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());
    @Override
    public String getMessage() {
        return "Couldn't connect to Database";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof SQLException;
    }

    @Override
    public void handle(Exception exception, Supplier method) throws InterruptedException {
        System.out.println("Trying to reconnect:");
        if (ReDo.redoWithDelay(method,3)){
            return;
        }
        System.out.println(getMessage());
        logger.error(getMessage());
    }
}

