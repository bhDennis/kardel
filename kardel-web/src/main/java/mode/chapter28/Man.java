package mode.chapter28;

/**
 * Created by dennis on 2018/4/11.
 */
public class Man extends Person{

    @Override
    void accept(Action action) {
        action.getManConclusion(this);
    }
}
