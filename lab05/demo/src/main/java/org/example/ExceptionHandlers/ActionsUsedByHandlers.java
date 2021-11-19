package org.example.ExceptionHandlers;

import org.example.Supplier;

public class ActionsUsedByHandlers {

    private int i = 0;
    private boolean aBoolean = true;
    public boolean canRepeat(Supplier method, int refreshRate) {
        if(i < 3) {
            try {
                method.get();
            } catch (Exception ignore) {
                i++;
                System.out.println("Retry: " + i +"..");
                wait(refreshRate);
                canRepeat(method, refreshRate);
            }
        }else{
            i = 0;
            aBoolean = false;
            System.out.println("Retry: Failed");
        }
        return aBoolean;
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
