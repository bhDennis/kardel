package mode.chapter8;

public class LeiFengFactoryTest {


    public static void main(String[] args){

        ILeiFengFactory leiFengFactory = new UndergraduteFactory();

        LeiFeng instance = leiFengFactory.createLeiFeng();

        instance.buyRice();

        instance.sweep();

        instance.wash();
    }
}
