package mode.chapter2;

public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
