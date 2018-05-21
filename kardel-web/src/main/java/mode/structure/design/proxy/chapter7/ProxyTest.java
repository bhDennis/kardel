package mode.structure.design.proxy.chapter7;

public class ProxyTest {

    public static void main(String[] args){

        SchoolGirl schoolGirl = new SchoolGirl("晓丽");

        Proxy proxy = new Proxy(schoolGirl);

        proxy.giveDolls();

        proxy.giveFlowers();

        proxy.giveChocolate();
    }
}
