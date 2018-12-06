package mode.behavior.design.command.chapter23;

/**
 * Created by dennis on 2018/3/22.
 */
public class AbstractCommandTest {

    public static void main(String[] args){

        Barbecue barbecue = new Barbecue(); //烧烤者（命令执行者）
        Waiter waiter = new Waiter();      //服务员（命令发起者）

        AbstractCommand abstractCommand = new RoastchickenCommand(barbecue);//烤鸡命令
        waiter.addAbstractCommand(abstractCommand);

        abstractCommand = new LambshashlikCommand(barbecue);//烤羊肉串命令
        waiter.addAbstractCommand(abstractCommand);

        waiter.notice();
    }
}
