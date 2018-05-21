package mode.creational.design.factory.method.chapter8;

public class UndergraduateFactory implements ILeiFenFactory {

    @Override
    public LeiFen createLeiFen() {
        return new Undergraduate();
    }
}
