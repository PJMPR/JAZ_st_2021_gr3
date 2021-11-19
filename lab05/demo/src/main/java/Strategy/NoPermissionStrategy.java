package Strategy;

import Logger.Logger;

import java.lang.reflect.Method;

public class NoPermissionStrategy implements Strategy{
    String name = "NoPermissionException";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void whatToDo(Class objectToInvokeMethodFrom, String name, Logger logger){
        try {
            Class c = Class.forName(objectToInvokeMethodFrom.getName());
            Object o = c.newInstance();
            Method m = c.getDeclaredMethod(name);
            m.setAccessible(true);
            m.invoke(o);
        } catch (Exception e){
            logger.loggerError(getName(), e);

        }
    }
}
