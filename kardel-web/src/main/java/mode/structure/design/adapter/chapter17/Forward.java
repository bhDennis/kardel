package mode.structure.design.adapter.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public class Forward extends AbstractPlayer {

    public Forward(String name){
        super(name);
    }

    @Override
    void attack() {
        System.out.println("forward"+getName()+"attack");
    }

    @Override
    void defense() {
        System.out.println("forward"+getName()+"defense");
    }
}
