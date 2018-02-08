package mode.chapter14;

public class ConcreteObserverTwo extends AbstractObserver{

    public ConcreteObserverTwo(String name, AbstractSubject abstractSubject) {
        super(name, abstractSubject);
    }

    @Override
    public void getResult(){

        System.out.println(abstractSubject.getAction()+","+name + "关闭NBA,快去工作");
    }
}
