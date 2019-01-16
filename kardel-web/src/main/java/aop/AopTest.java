package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dennis on 2018/8/13.
 */
public class AopTest {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        IHumanService iHuman =  context.getBean(ChineseService.class);
        iHuman.chifan();
        iHuman.shuijiaon();
    }
}
