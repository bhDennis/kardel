package me.dennis.exercise.test;

/**
 * Created by dennis on 2018/12/28.
 */
public enum EnumProductInformationType {

    NO_TASK(0, "无任务"),
    BIG_PRODUCT(1,"第五步");

    EnumProductInformationType(Integer flow,String value){
        this.flow = flow;
        this.value = value;
    }

    private Integer flow;
    private String value;

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static EnumProductInformationType getByFlow(Integer flow){

        for(EnumProductInformationType enumProductInformationType : EnumProductInformationType.values()){

            if(enumProductInformationType.getFlow() == flow){
                return enumProductInformationType;
            }
        }

        return null;
    }
}
