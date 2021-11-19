import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.concurrent.TimeoutException;

public class testClass {
    public void ss(){
        System.out.println("sss");
    }
    public void t() throws TimeoutException {
        throw new TimeoutException();
    }
    public void a() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
