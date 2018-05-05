package mode.chapter23;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * 服务员
 * Created by dennis on 2018/3/22.
 */
public class Waiter {

    private List<AbstractCommand> abstractCommandList = new ArrayList<>();

    public void addAbstractCommand(AbstractCommand abstractCommand){

        System.out.println("增加订单，时间"+new Date());
        abstractCommandList.add(abstractCommand);
    }

    public void removeAbstractCommand(AbstractCommand abstractCommand){

        System.out.println("取消订单，时间"+new Date());
        abstractCommandList.remove(abstractCommand);
    }

    public void notice(){
        abstractCommandList.forEach(command->{
            command.executeCommand();
        });
    }
}
