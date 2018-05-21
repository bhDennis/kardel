package mode.behavior.design.obserer.chapter14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConcreteSubjectExt extends AbstractSubjectExt{

    @Override
    void notifySomething(Method method, Object ... objs){

        try {
            method.invoke(method.getDeclaringClass().newInstance(),objs);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
