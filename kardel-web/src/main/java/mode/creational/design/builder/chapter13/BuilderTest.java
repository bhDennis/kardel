package mode.creational.design.builder.chapter13;

public class BuilderTest {

    public static void main(String[] args){

        Director director = new Director();

        System.out.println("--使用ConcreteBuilderA构造产品--");
        Builder builder = new ConcreteBuilderA();
        director.construct(builder);

        Product product = builder.getResult();
        product.show();

        System.out.println("--使用ConcreteBuilderB构造产品--");
        builder = new ConcreteBuilderB();
        director.construct(builder);

        product = builder.getResult();
        product.show();

    }
}
