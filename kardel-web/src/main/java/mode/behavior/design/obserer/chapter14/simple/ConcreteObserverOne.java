package mode.behavior.design.obserer.chapter14.simple;

public class ConcreteObserverOne extends AbstractObserver{

    public ConcreteObserverOne(String name, AbstractSubject abstractSubject) {
        super(name, abstractSubject);
    }

    @Override
    public void getResult() {

        System.out.println(abstractSubject.getAction()+","+name + "关闭股票,快去工作");
    }
}
