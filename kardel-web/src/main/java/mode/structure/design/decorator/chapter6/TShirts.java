package mode.structure.design.decorator.chapter6;

public class TShirts extends Finery{

    public void show(){

        System.out.println("大T恤");

        component.show();
    }
}
