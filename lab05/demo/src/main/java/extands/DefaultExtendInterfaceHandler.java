package extands;

import org.apache.log4j.Logger;
import org.example.Supplier;

public class DefaultExtendInterfaceHandler implements ExtandHandler{
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());
    @Override
    public String getMessage() {
        return "Unknown extand";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return true;
    }

    @Override
    public void handle(Exception exception, Supplier method) {
        System.out.println(getMessage());
        logger.error(getMessage());
    }
}
