package mode.chapter14;

import java.util.List;
import java.util.ArrayList;

public class ConcreteSubject extends AbstractSubject{

    private List<AbstractObserver> abstractObservers = new ArrayList<>();

    @Override
    void add(AbstractObserver abstractObserver) {

        abstractObservers.add(abstractObserver);
    }

    @Override
    void decrease(AbstractObserver abstractObserver) {

        abstractObservers.remove(abstractObservers);
    }

    @Override
    void notifySomething() {

        for (AbstractObserver abstractObserver : abstractObservers){

            abstractObserver.getResult();
        }
    }
}
