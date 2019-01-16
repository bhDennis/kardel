package mode.behavior.design.duty.chapter24;

/**
 * Created by dennis on 2018/3/26.
 */
public class Manager implements IHandler {

    @Override
    public boolean handle(Request request) {

        if(request.getEnumRequestType().equals(EnumRequestType.ASK_FOR_LEAVE) && request.getDays() < 2){
            System.out.println("manager->agree");
            return true;
        }
        return false;
    }
}
