package mode.creational.design.builder.chapter13;

public class ConcreteBuilderB extends Builder{


    private Product product = new Product();

    @Override
    void buildA() {

        product.add("部件b1");
    }

    @Override
    void buildB() {

        product.add("部件b2");
    }

    @Override
    Product getResult() {
        return product;
    }
}
