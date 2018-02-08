package mode.chapter14;

public class ConcreteSubjectTest {

    public static void main(String[] args){

        AbstractSubject abstractSubject = new ConcreteSubject();
        abstractSubject.setAction("老板回来了");

        AbstractObserver abstractObserverOne = new ConcreteObserverOne("老王",abstractSubject);
        AbstractObserver abstractObserverTwo = new ConcreteObserverTwo("老李",abstractSubject);

        abstractSubject.add(abstractObserverOne);
        abstractSubject.add(abstractObserverTwo);

        abstractSubject.notifySomething();
    }
}
