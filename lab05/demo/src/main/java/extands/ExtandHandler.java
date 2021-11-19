package extands;

import org.example.Supplier;

public interface ExtandHandler {
    String getMessage();
    boolean canHandle(Exception exception);
    void handle(Exception exception, Supplier method) throws InterruptedException;

}
