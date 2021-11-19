package Strategy;


import Logger.Logger;

import java.lang.reflect.Method;

public interface Strategy {
    String getName();
    Logger logger = new Logger();

    default void whatToDo(Class objectToInvokeMethodFrom, String name, Logger logger) {

    }


    default void invoke(Class objectToInvokeMethodFrom,String name){
        try {

            Class c = Class.forName(objectToInvokeMethodFrom.getName());
            Object o = c.newInstance();
            Method m = c.getDeclaredMethod(name);
            m.setAccessible(true);
            m.invoke(o);

        } catch (Exception e){}

    }
}

