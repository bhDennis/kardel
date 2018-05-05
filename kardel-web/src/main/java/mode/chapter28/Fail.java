package mode.chapter28;

/**
 * Created by dennis on 2018/4/11.
 */
public class Fail extends Action{

    @Override
    void getManConclusion(Man man) {

        System.out.println("男人失败时，闷头喝酒，谁也不用劝");
    }

    @Override
    void getWomenConclusion(Women women) {

        System.out.println("女人失败时，眼泪汪汪，谁也劝不了");
    }
}
