package FixingExceptions;

import Supplier.Suplier;

import java.util.concurrent.TimeUnit;


public class FixException {
    protected int times;
    protected int second;

    public FixException(int times, int second) {
        this.times = times;
        this.second = second;
    }

    public void whait(){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void tryToFix(Suplier methodSupplier){
        for (int i = 0; i < times; i++){
            try {
                System.out.println("Try to run a method");
                methodSupplier.execute();

            }catch (Exception e){
                //ingnore
                whait();
                System.out.println("Waiting");
            }
        }
    }
}


