package extands;

import org.apache.log4j.Logger;
import org.example.Supplier;


public class ClassNotFoundHandler implements ExtandHandler{
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());
    @Override
    public String getMessage() {
        return "Class not found";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof ClassNotFoundException;
    }

    @Override
    public void handle(Exception exception, Supplier method) {
        if (canHandle(exception)){
            System.out.println(getMessage());
            logger.error(getMessage());
        }

    }
}
