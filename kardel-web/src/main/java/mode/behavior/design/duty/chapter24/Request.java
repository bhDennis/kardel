package mode.behavior.design.duty.chapter24;

/**
 * Created by dennis on 2018/3/26.
 */
public class Request {

    private EnumRequestType enumRequestType;

    private Integer days;

    public Request(EnumRequestType enumRequestType,Integer days){
        this.enumRequestType = enumRequestType;
        this.days = days;
    }

    public EnumRequestType getEnumRequestType() {
        return enumRequestType;
    }

    public void setEnumRequestType(EnumRequestType enumRequestType) {
        this.enumRequestType = enumRequestType;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}

enum EnumRequestType{

    ASK_FOR_LEAVE(1,"请假"),
    RAISE(2,"加薪");

    Integer code;
    String value;

    EnumRequestType(Integer code,String value){

        this.code = code;
        this.value = value;
    }
}
