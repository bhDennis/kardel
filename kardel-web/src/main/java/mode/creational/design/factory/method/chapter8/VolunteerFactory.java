package mode.creational.design.factory.method.chapter8;

public class VolunteerFactory implements ILeiFenFactory {

    @Override
    public LeiFen createLeiFen() {
        return new Volunteer();
    }
}
