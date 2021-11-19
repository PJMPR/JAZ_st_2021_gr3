

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SaveInvoker invoker = new SaveInvoker();
        invoker.invoke(testClass.class,"t");

    }
}
