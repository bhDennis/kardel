package mode.chapter24;

/**
 * Created by dennis on 2018/3/26.
 */
public class GeneralManager implements IHandler {

    @Override
    public boolean handle(Request request) {

        if(request.getEnumRequestType().equals(EnumRequestType.ASK_FOR_LEAVE)) {

            System.out.println("general manager->agree");
            return true;
        }
        return false;
    }
}
