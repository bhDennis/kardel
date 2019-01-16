package mode.behavior.design.command.chapter23;

/**
 * 烤羊肉串
 * Created by dennis on 2018/3/22.
 */
public class LambshashlikCommand extends AbstractCommand {

    public LambshashlikCommand(Barbecue barbecue){
        super(barbecue);
    }

    @Override
    protected void executeCommand() {

        barbecue.executeLambshashlik();
    }
}
