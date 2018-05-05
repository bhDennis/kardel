package mode.chapter20;

/**
 * Created by dennis on 2018/3/14.
 */
public abstract class AbstractAggregate<T> {

    abstract AbstractIterator<T>  createAbstractIterator();

    abstract int size();

    abstract T get(int index);

    abstract boolean add(T t);
}
