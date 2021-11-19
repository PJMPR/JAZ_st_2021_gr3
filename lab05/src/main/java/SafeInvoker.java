import ExceptionsHandlers.*;
import Supplier.Suplier;


import java.util.ArrayList;
import java.util.List;

public class SafeInvoker {

    private final List<ExceptionHandlerEXC> exceptionHandlers = new ArrayList<>(List.of(
            new FileNotFindEXC(),
            new FileAlreadyProcesingEXC(),
            new LostConectionEXC(),
            new AccesDeniedEXC(),
            new DefaultExceptionEXC()

    ));

    public void invoke(Suplier method) {

        try {
            method.execute();
            System.out.println(" Jesteśmy w invoke po w try");
        } catch (Exception exeption) {
            System.out.println(" Jesteśmy w invoke w catchu");
            for(ExceptionHandlerEXC exceptionHandler : exceptionHandlers){
                exceptionHandler.catchException(method, exeption);
            }
        }
    }
}
