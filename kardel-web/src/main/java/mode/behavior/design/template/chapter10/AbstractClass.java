package mode.behavior.design.template.chapter10;

public abstract class AbstractClass {

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    public void templateMethod(){

        primitiveOperation1();
        primitiveOperation2();

        System.out.println("i am a template method");
    }
}
