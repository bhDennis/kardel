package mode.behavior.design.obserer.chapter14.simple;

// 抽象通知者
public abstract class AbstractSubject {

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    abstract void add(AbstractObserver abstractObserver);

    abstract void decrease(AbstractObserver abstractObserver);

    abstract void notifySomething();
}
