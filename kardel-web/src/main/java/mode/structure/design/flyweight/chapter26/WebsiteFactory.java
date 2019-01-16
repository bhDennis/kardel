package mode.structure.design.flyweight.chapter26;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 2018/4/3.
 */
public class WebsiteFactory {

    public static Map<String,Website> websiteMap = new HashMap<>();

    public Website getWebsite(String webSiteName){

        if(!websiteMap.containsKey(webSiteName)){
            websiteMap.put(webSiteName,new ConcreteWebsite(webSiteName));
        }
        return websiteMap.get(webSiteName);
    }

    public int getWebsiteCount(){
        return websiteMap.size();
    }
}
