import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

public class SafeInvokerTests {

    public void testy() throws TimeoutException {
        throw new TimeoutException();
    }

    @Test
    public void shouldThrowAnError(){
        var invoker = new SafeInvoker();
        invoker.invoker(this::testy,3,()->{ });
    }
}
