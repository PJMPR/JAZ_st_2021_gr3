package org.example;

public class Actions {
    public void wait(int time) {
        try {
            Thread.sleep(time * 1500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean tryAgain(Provider method, int counter) {
        if (counter > 0) {
            System.out.println("Attempts left:" + counter);
            try {
                method.execute();
                return true;
            } catch (Exception e) {
                wait(10);
                tryAgain(method, counter);
            }
            return false;
        }
    }
}


