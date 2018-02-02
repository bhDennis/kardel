package mode.chapter13;

public class ConcreteBuilderA extends Builder{

    private Product product = new Product();

    @Override
    void buildA() {

        product.add("部件a1");
    }

    @Override
    void buildB() {

        product.add("部件a2");

    }

    @Override
    Product getResult() {
        return product;
    }
}
