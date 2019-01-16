package mode.structure.design.proxy.chapter7;

public class Proxy implements GiveGift{

    private Pursuit pursuit;

    public Proxy(SchoolGirl schoolGirl){
        pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
