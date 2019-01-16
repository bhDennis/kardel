package mode.behavior.design2.iterator.chapter20;

/**
 * Created by dennis on 2018/3/14.
 */
public abstract class AbstractIterator<T> {

    abstract T first();

    abstract T next();

    abstract boolean isDone();

    abstract T currentItem();
}
