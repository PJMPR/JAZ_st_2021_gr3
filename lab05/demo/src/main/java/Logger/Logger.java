package Logger;

public class Logger {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    public void loggerError(String message, Exception error) {
        logger.error(message, error);
    }
}
