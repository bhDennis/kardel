package mode.behavior.design2.mediator.chapter25;

/**
 * Created by dennis on 2018/3/29.
 */
public class USA extends Country{

    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message){
        unitedNations.declare(message,this);
    }

    public void getMessage(String message){
        System.out.println("USA获得的消息:"+message);
    }
}
