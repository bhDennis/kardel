package mode.chapter22;

/**
 * Created by dennis on 2018/3/22.
 */
public class AbstractMobileBrandTest {

    public static void main(String[] args){

        AbstractMobileBrand abstractMobileBrand;

        abstractMobileBrand = new NokiaMobileBrand();
        abstractMobileBrand.setAbstractMobileSoftware(new AddressListMobileSoftware());

        abstractMobileBrand.run();

        abstractMobileBrand.setAbstractMobileSoftware(new AudioPlayerMobileSoftware());
        abstractMobileBrand.run();

        System.out.println("--上面是诺基亚品牌，下面是苹果品牌--");

        abstractMobileBrand = new AppMobileBrand();
        abstractMobileBrand.setAbstractMobileSoftware(new AddressListMobileSoftware());

        abstractMobileBrand.run();

        abstractMobileBrand.setAbstractMobileSoftware(new AudioPlayerMobileSoftware());
        abstractMobileBrand.run();
    }
}
