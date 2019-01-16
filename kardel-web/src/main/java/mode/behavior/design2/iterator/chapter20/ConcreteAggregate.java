package mode.behavior.design2.iterator.chapter20;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by dennis on 2018/3/14.
 */
public class ConcreteAggregate<T> extends AbstractAggregate<T> {

    private final List<T> instances = new ArrayList();

    @Override
    AbstractIterator<T> createAbstractIterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int size(){
        return instances.size();
    }

    @Override
    public T get(int index){

        return instances.get(index);
    }

    @Override
    public boolean add(T t) {
        return instances.add(t);
    }
}
