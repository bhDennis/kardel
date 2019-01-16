package mode.behavior.design.obserer.chapter14.simple;

// 抽象观察者
public abstract class AbstractObserver {

    protected String name;

    protected AbstractSubject abstractSubject;

    public AbstractObserver(String name, AbstractSubject abstractSubject) {
        this.name = name;
        this.abstractSubject = abstractSubject;
    }

    protected abstract void getResult();
}
