import org.example.SafeInvoker;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class HandlersTests {
    SafeInvoker invoker = new SafeInvoker();

    @Test
    public void FileNotFoundExceptionHandlerTest() {
        invoker.invoke(this, new FileNotFoundException(), "FileNotFoundExceptionHandlerTest");
    }

    @Test
    public void TimeoutExceptionHandlerTest(){
        invoker.invoke(this, new TimeoutException(), "TimeoutExceptionHandlerTest");
    }
}
