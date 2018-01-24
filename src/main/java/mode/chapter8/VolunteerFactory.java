package mode.chapter8;

public class VolunteerFactory implements ILeiFengFactory{

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
