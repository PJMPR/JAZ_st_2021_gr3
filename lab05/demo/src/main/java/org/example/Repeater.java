package org.example;

public class Repeater {
    public static boolean repeater(Invoker method, int i) throws InterruptedException {
        while(i > 0){
            try {
                method.invoke();
                return true;
            } catch (Exception e){
                Thread.sleep(3 + 1000L);
                i--;
            }
        }
        return false;
    }
}
