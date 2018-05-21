package mode.behavior.design2.vistor.chapter28;

/**
 * Created by dennis on 2018/4/11.
 */
public class Women extends Person{

    @Override
    void accept(Action action) {
        action.getWomenConclusion(this);
    }
}
