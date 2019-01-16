package mode.behavior.design.obserer.chapter14;

public class ConcreteObserverTwoExt extends AbstractObserverExt{

    public ConcreteObserverTwoExt(String name, AbstractSubjectExt abstractSubject) {
        super(name, abstractSubject);
    }

    @Override
    public void getResult(){

        System.out.println(abstractSubject.getAction()+","+name + "关闭NBA,快去工作");
    }
}
