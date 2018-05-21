package mode.structure.design.decorator.chapter6;

public class FineryTest {

    public static void main(String[] args){

        Person person = new Person("小菜");

        TShirts tShirts = new TShirts();

        BigTrouser bigTrouser = new BigTrouser();

        tShirts.decorate(person);

        bigTrouser.decorate(tShirts);

        bigTrouser.show();
    }
}
