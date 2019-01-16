package mode.structure.design.flyweight.chapter26;

/**
 * Created by dennis on 2018/4/3.
 */
public class WebsiteFactoryTest {

    public static void main(String[] args){

        WebsiteFactory websiteFactory = new WebsiteFactory();

        Website websiteX = websiteFactory.getWebsite("产品展示");
        websiteX.use(new User("小A"));

        Website websiteY = websiteFactory.getWebsite("产品展示");
        websiteY.use(new User("小B"));

        Website websiteC = websiteFactory.getWebsite("微博");
        websiteC.use(new User("小C"));

        int count = websiteFactory.getWebsiteCount();
        System.out.println(count);
    }
}
