package mode.chapter20;

/**
 * Created by dennis on 2018/3/14.
 */
public class ConcreteIterator<T> extends AbstractIterator<T> {

    private ConcreteAggregate<T> concreteAggregate;

    private int currentIndex = 0;

    public ConcreteIterator (ConcreteAggregate<T> concreteAggregate){

        this.concreteAggregate = concreteAggregate;
    }

    @Override
    T first() {
        return concreteAggregate.get(0);
    }

    @Override
    T next() {

        currentIndex ++;

        if(currentIndex < concreteAggregate.size()){

            return currentItem();
        }

        return null;
    }

    @Override
    boolean isDone() {
        return currentIndex >= concreteAggregate.size() ? true : false;
    }

    @Override
    T currentItem() {
        return concreteAggregate.get(currentIndex);
    }
}
