package Errors;

public class Retry {
    public static boolean retry(ExceptionThrower target, int times, int ms) {
        for (int i = times; i > 0; i--) {
            try {
                target.throwException();
                return false;
            } catch (Exception e) {
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return true;
    }
}
