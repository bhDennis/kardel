package mode.chapter23;

/**
 * Created by dennis on 2018/3/22.
 */
public class AbstractCommandTest {

    public static void main(String[] args){

        Barbecue barbecue = new Barbecue(); //烧烤者

        AbstractCommand abstractCommand = new RoastchickenCommand(barbecue);//烤鸡命令

        Waiter waiter = new Waiter();      //服务员
        waiter.addAbstractCommand(abstractCommand);

        abstractCommand = new LambshashlikCommand(barbecue);//烤羊肉串命令
        waiter.addAbstractCommand(abstractCommand);

        waiter.notice();
    }
}
