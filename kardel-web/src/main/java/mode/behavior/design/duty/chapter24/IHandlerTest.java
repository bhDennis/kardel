package mode.behavior.design.duty.chapter24;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by dennis on 2018/3/26.
 */
public class IHandlerTest {

    public static void main(String[] args){

        List<IHandler> iHandlerList = new ArrayList<>(3);
        iHandlerList.add(new Manager());
        iHandlerList.add(new Majordomo());
        iHandlerList.add(new GeneralManager());

        HandleContext handleContext = new HandleContext();
        handleContext.setIHandlers(iHandlerList);
        handleContext.setRequest(new Request(EnumRequestType.ASK_FOR_LEAVE,4));

        handleContext.iteratorIHandler();
    }
}
