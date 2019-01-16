package mode.behavior.design.obserer.chapter14;

public class ConcreteObserverOneExt extends AbstractObserverExt{

    public ConcreteObserverOneExt(String name, AbstractSubjectExt abstractSubject) {
        super(name, abstractSubject);
    }

    @Override
    public void getResult() {

        System.out.println(abstractSubject.getAction()+","+name + "关闭股票,快去工作");
    }
}
