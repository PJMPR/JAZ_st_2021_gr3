package org.example;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args){

        File f = new File("");
        if(f.exists()&&!f.isDirectory()){
            try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))){

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List.of(1,2,3,4,5,6,7,8,9,10).stream().parallel().forEach(x->System.out.println(x));

        Stream.generate(()->"").limit(1).map(x->new Object()).filter(x->x instanceof String)
                .map(x->1)
                .collect(Collectors.toList());

        Map<String,String> envs = System.getenv();
        int number = 10;
        double d1 = number;
        new SafeInvoker().invoke(()->{
        Double d = new SafeCaster().cast(number, Double.class);
        //if(d!=null)
        System.out.println(d);
        });

        Object tst = "test";
        String s = new SafeCaster().cast(tst, String.class);
        System.out.println(s);

        new SafeInvoker().invoke(()->{
            new FileInputStream("");
        });
        try {
            Singleton.SINGLETON.consume();
        } catch (Exception e) {


        }

        ThrowableConsumer<Exception> tmp = Singleton.SINGLETON;
    }



}


interface ThrowableConsumer<T extends Exception>{
    void consume() throws T;
}

enum Singleton implements ThrowableConsumer<Exception>{
    SINGLETON;

    @Override
    public void consume() {

    }
}

class SafeInvoker{

    public <T extends Exception> void invoke(ThrowableConsumer<T> throwableConsumer){
        try{
            throwableConsumer.consume();
        }catch(Exception ex){
            T exc = (T)ex;
            System.out.println(exc.getClass().getName());
        }
    }

}

class SafeCaster{

    public <T,E> T cast(E obj, Class<T> clazz){

        T result = null;
        try{
            if(obj != null) result = (T)obj;
        return result;
        }

            catch (ClassCastException ex){
                //ex.printStackTrace();
            }
        return null;
    }

}