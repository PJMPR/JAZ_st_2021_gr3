package Lab06.Exception;

public class CreditNotFoundException extends Exception {
    public CreditNotFoundException( ) {
        super("Can not find credit with id ");
    }
}
