package ExceptionsHandlers;

import Supplier.Suplier;

public class LostConectionEXC implements ExceptionHandlerEXC {

    @Override
    public String message() {
        return null;
    }

    @Override
    public boolean matchExeption(Exception e) {
        return false;
    }

    @Override
    public void tryTofix(Suplier methodSupplier) {

    }

    @Override
    public void catchException(Suplier methodSupplier, Exception exception) {

    }
}
