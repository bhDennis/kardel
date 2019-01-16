package mode.structure.design.flyweight.chapter26;

/**
 * Created by dennis on 2018/4/3.
 */
public class ConcreteWebsite extends Website{

    private String websiteName;

    public String getWebsiteName() {
        return websiteName;
    }

    public ConcreteWebsite(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    void use(User user) {
        System.out.println("网站分类:"+websiteName+"->用户："+user.getName());
    }
}
