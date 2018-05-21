package mode.behavior.design2.strategy.chapter2;

/**
 *
 * 生成具体策略实例也可使用简单工厂的方式，与Context方式相比，
 * 简单工厂的方式会让客户端认识两个类，即工厂类和CashSuper，
 * CashContext方式只会让客户端认识一个类，这样降低了耦合度。（p.58）
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(String type) {

        switch (type){

            case "normal" :
                cashSuper = new CashNormal();break;
            case "300 rebate 100" :
                cashSuper = new CashReturn("300","100");break;
            case "80%" :
                cashSuper = new CashRebate("0.8");break;
        }
    }

    public double getResult(double money){
        return  cashSuper.acceptCash(money);
    }
}
