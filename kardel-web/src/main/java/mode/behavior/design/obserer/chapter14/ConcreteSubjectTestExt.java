package mode.behavior.design.obserer.chapter14;

import java.lang.reflect.InvocationTargetException;

public class ConcreteSubjectTestExt {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        AbstractSubjectExt abstractSubject = new ConcreteSubjectExt();
        abstractSubject.setAction("老板回来了");

        AbstractObserverExt abstractObserverOne = new ConcreteObserverOneExt("老王",abstractSubject);
        AbstractObserverExt abstractObserverTwo = new ConcreteObserverTwoExt("老李",abstractSubject);

        abstractSubject.notifySomething(ConcreteObserverOneExt.class.getMethods()[0] ,"老王",abstractSubject);
        abstractSubject.notifySomething(ConcreteObserverTwoExt.class.getMethods()[0],"老李",abstractSubject);
    }
}
