package mode.behavior.design.status.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class Work {

    private State state;

    private double hour;

    private Boolean workFinished = false;

    public Work(){
        state = new ForenoonState();
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void execute(){
        state.writeProgram(this);
    }

    public Boolean getWorkFinished() {
        return workFinished;
    }

    public void setWorkFinished(Boolean workFinished) {
        this.workFinished = workFinished;
    }
}
