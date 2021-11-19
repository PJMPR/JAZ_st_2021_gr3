import org.example.SafeInvoker;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class HandlersTests {

    SafeInvoker invoker = new SafeInvoker();

    @Test
    public void FileNotFoundExceptionHandlerTest() throws Exception {
        invoker.invoke(() -> {
            throw new FileNotFoundException();
        });
    }

    @Test
    public void TimeOutExceptionHandlerTest() throws Exception {
        invoker.invoke(() -> {
            throw new TimeoutException();
        });
    }

    @Test
    public void doNotThrowAnyExceptionTest() throws Exception {
        invoker.invoke(() -> System.out.println("Hello"));
    }
}
