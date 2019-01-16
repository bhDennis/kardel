package mode.behavior.design.command.chapter23;


/**
 * Created by dennis on 2018/3/22.
 */
public abstract class AbstractCommand {

    protected Barbecue barbecue;

    public AbstractCommand(Barbecue barbecue) {
        this.barbecue = barbecue;
    }
    protected abstract void executeCommand();
}
