package mode.chapter8;

public class UndergraduteFactory implements ILeiFengFactory{

    @Override
    public LeiFeng createLeiFeng() {
        return new Undergradute();
    }
}
