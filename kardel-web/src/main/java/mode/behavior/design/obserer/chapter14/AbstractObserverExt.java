package mode.behavior.design.obserer.chapter14;

// 抽象观察者
public abstract class AbstractObserverExt {

    protected String name;

    protected AbstractSubjectExt abstractSubject;

    public AbstractObserverExt(String name, AbstractSubjectExt abstractSubject) {
        this.name = name;
        this.abstractSubject = abstractSubject;
    }

    protected abstract void getResult();
}
