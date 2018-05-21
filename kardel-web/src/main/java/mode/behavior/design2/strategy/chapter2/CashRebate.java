package mode.behavior.design2.strategy.chapter2;

public class CashRebate extends CashSuper{

    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate){

        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
