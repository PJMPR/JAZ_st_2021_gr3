package extands;

import org.example.Supplier;

public class ReDo {
    public static boolean redoWithDelay(Supplier method, int repeats) throws InterruptedException {
        if (repeats > 0){
            try{
                method.execute();
                return true;

            } catch (Exception e) {
                Thread.sleep(3);
                repeats--;
            }
        }
        return false;
    }
}
