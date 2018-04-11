package mode.chapter28;

/**
 * Created by dennis on 2018/4/11.
 */
public class Success extends Action{

    @Override
    void getManConclusion(Man man) {

        System.out.println("男人成功时，背后多半有一个伟大的女人");
    }

    @Override
    void getWomenConclusion(Women women) {

        System.out.println("女人成功时，背后大多有一个不成功的男人");
    }
}
