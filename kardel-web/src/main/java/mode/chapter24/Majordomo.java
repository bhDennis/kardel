package mode.chapter24;

/**
 * Created by dennis on 2018/3/26.
 */
public class Majordomo implements IHandler {

    @Override
    public boolean handle( Request request) {

        if(request.getEnumRequestType().equals(EnumRequestType.ASK_FOR_LEAVE) && request.getDays() < 5){

            System.out.println("majordomo->agree");
            return true;
        }
        return false;
    }
}
