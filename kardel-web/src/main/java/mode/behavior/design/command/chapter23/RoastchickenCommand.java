package mode.behavior.design.command.chapter23;

/**
 * 烤鸡
 * Created by dennis on 2018/3/22.
 */
public class RoastchickenCommand extends AbstractCommand {

    public RoastchickenCommand(Barbecue barbecue){
        super(barbecue);
    }

    @Override
    protected void executeCommand() {
        barbecue.executeRoastchicken();
    }
}
