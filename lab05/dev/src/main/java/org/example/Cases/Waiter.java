package org.example.Cases;

import org.example.Provider;

public class Waiter {

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean reapeat(Provider method, int t) {
        while (t > 0) {
            System.out.println("Attempts left: " + t);
            try {
                method.execute();
                return true;
            } catch (Exception err) {
                wait(3);
                t--;
            }
        }
        return false;
    }

}