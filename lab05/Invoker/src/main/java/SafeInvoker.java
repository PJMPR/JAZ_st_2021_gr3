import com.sun.jdi.Method;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


interface MethodTest{
    void invoke() throws Exception;
}

public class SafeInvoker {
    private static final Logger logger = LogManager.getLogger(SafeInvoker.class);


    public void invoker(MethodTest method, int howManyTimesToReRun, MethodTest alternativeMethod) {
        try {
            method.invoke();
        } catch (Throwable e) {
            logger.log(Level.ERROR, "Error invoking method", e.getCause());
            if (howManyTimesToReRun <= 0) {
                logger.log(Level.FATAL, "Too many errors, exiting");

                try {
                    alternativeMethod.invoke();
                } catch (Exception ex) {
                    logger.log(Level.FATAL, "Error invoking alternative method", ex.getCause());
                    ex.printStackTrace();
                }
            }
            else {
                logger.log(Level.INFO, "Retrying in 5 seconds");
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e1) {
                    logger.log(Level.INFO, "Interrupted while waiting for retry", e1);
                }
                invoker(method, --howManyTimesToReRun,alternativeMethod);
            }
        }
    }
}
