package mode.behavior.design.duty.chapter24;

import java.util.List;
/**
 * Created by dennis on 2018/3/26.
 */
public class HandleContext {

    private List<IHandler>  iHandlers;

    private Request request;

    public List<IHandler> getiHandlers() {
        return iHandlers;
    }

    public void setIHandlers(List<IHandler> iHandlers) {
        this.iHandlers = iHandlers;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void iteratorIHandler(){

        for(IHandler iHandler : iHandlers){
            boolean result = iHandler.handle(request);
            if(result){
                break;
            }
        }
    }
}
