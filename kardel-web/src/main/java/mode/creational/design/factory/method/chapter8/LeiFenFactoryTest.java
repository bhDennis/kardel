package mode.creational.design.factory.method.chapter8;

public class LeiFenFactoryTest {

    public static void main(String[] args){

        ILeiFenFactory leiFenFactory = new UndergraduateFactory();

        LeiFen instance = leiFenFactory.createLeiFen();

        instance.buyRice();

        instance.sweep();

        instance.wash();
    }
}
