package mode.chapter1;

public class OperationAdd extends Operation{


    @Override
    protected double getResult() {
        return get_numberA() + get_numberB();
    }
}