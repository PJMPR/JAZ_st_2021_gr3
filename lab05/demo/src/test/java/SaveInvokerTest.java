import org.example.SafeInvoker;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class SaveInvokerTest {

    SafeInvoker safeInvoker = new SafeInvoker();

    @Test
    public void CheckIfFileNotFoundWorks(){
        safeInvoker.invoke(() -> {throw new FileNotFoundException();
        });
    }
    @Test
    public void CheckIfDefaultExtandWorks(){
        safeInvoker.invoke(() -> {throw new SQLException();
        });
    }
    @Test
    public void CheckIfTimeOutWorks(){
        safeInvoker.invoke(() -> {throw new TimeoutException();
        });
    }
    @Test
    public void CheckIfClassNotFoundWorks(){
        safeInvoker.invoke(() -> {throw new ClassNotFoundException();
        });
    }
 

}
