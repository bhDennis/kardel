package mode.behavior.design.template.chapter10;

public class AbstractClassTest {

    public static void main(String[] args){

        AbstractClass abstractClass;

        abstractClass = new ConcreteClassA();
        abstractClass.templateMethod();

        abstractClass = new ConcreteClassB();
        abstractClass.templateMethod();
    }
}
