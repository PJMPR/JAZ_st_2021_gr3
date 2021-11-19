package extands;

import org.apache.log4j.Logger;
import org.example.Supplier;

import java.io.FileNotFoundException;

public class FileNotFoundHandler implements ExtandHandler{
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());
    @Override
    public String getMessage() {
        return "File not found. Change ur file path.";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof FileNotFoundException;
    }

    @Override
    public void handle(Exception exception, Supplier method) {
        if(canHandle(exception)){
            System.out.println(getMessage());
            logger.error(getMessage());
        }

    }


}
