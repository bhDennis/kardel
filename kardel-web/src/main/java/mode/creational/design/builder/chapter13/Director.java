package mode.creational.design.builder.chapter13;

public class Director {

    public void construct(Builder builder){

        builder.buildA();

        builder.buildB();
    }
}
