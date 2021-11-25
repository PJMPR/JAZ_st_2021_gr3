import ExceptionsHandlers.AccesDeniedEXC;
import MYExceptions.AccesDeniedException;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class SafeInvokerTEST {


    @Test
    public void shouldnotThrowAccesDeniedEXC() throws FileNotFoundException {

        new SafeInvoker().invoke(throw new FileNotFoundException());
    }
}
