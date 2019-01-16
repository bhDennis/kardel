package mode.structure.design.adapter.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public class Guard extends AbstractPlayer {

    public Guard(String name){

        super(name);
    }

    @Override
    void attack() {
        System.out.println("guard"+getName()+"attack");
    }

    @Override
    void defense() {
        System.out.println("guard"+getName()+"defense");
    }
}
