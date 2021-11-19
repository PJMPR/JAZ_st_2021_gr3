import Errors.ErrorHandler;
import Errors.SQLTimeoutError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLTimeoutException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SafeInvokerTest {

    @InjectMocks
    private SafeInvoker safeInvoker;

    @Test
    public void findErrorHandlerShouldReturnSQLTimeoutError() {
        ErrorHandler errorHandler = safeInvoker.findErrorHandler(new SQLTimeoutException());
        assertEquals(SQLTimeoutError.class, errorHandler.getClass());
    }

    @Test
    public void FileNotFoundExceptionShouldBeHandled() {
        safeInvoker.invoke(() -> {
            throw new FileNotFoundException();
        });
    }

    @Test
    public void SQLInvalidAuthorizationSpecExceptationShouldBeHandled() {
        safeInvoker.invoke(() -> {
            throw new SQLInvalidAuthorizationSpecException();
        });
    }

    @Test
    public void SQLTimeoutExceptionShouldBeHandled() {
        safeInvoker.invoke(() -> {
            throw new SQLTimeoutException();
        });
    }

    @Test
    public void UnknownExceptionShouldBeHandled() {
        safeInvoker.invoke(() -> {
            throw new Exception();
        });
    }
}
