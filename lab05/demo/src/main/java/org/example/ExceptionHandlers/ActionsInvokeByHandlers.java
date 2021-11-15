package org.example.ExceptionHandlers;

import java.lang.reflect.InvocationTargetException;

public class ActionsInvokeByHandlers {

    public int i = 1;
    public void reDo(Object objOfMethod, String method){
        try {
            if(i < 3) {
                i++;
                objOfMethod.getClass().getMethod(method).invoke(objOfMethod);
            }else{
                i = 1;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
