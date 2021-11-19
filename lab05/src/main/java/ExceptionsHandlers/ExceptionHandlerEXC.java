package ExceptionsHandlers;


import Supplier.Suplier;

public interface ExceptionHandlerEXC {

      String message();

      boolean matchExeption(Exception e);

      void tryTofix(Suplier method);

      void catchException(Suplier methodSupplier , Exception exception);


}
