package aop;

import org.springframework.stereotype.Service;

/**
 * Created by Dennis on 2018/8/13.
 */
@Service
public class ChineseService implements IHumanService {

    @Override
    public int chifan() {
        System.out.println("Chinese吃饭");
        return 50;
    }

    @Override
    public void shuijiaon() {
        System.out.println("Chinese睡觉");
    }
}
