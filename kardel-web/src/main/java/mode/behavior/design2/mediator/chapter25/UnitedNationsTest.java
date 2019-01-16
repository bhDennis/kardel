package mode.behavior.design2.mediator.chapter25;

/**
 * Created by dennis on 2018/3/29.
 */
public class UnitedNationsTest {

    public static void main(String[] args){

        UnitedNationsSecurity unitedNations = new UnitedNationsSecurity();

        USA usa = new USA(unitedNations);
        Iraq iraq = new Iraq(unitedNations);

        unitedNations.setUsa(usa);
        unitedNations.setIraq(iraq);

        usa.declare("不许研制核武器,否则发动战争");
        iraq.declare("我们没有研制，随你便");
    }
}
