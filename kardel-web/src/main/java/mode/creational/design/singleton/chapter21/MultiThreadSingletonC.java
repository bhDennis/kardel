package mode.creational.design.singleton.chapter21;

/**
 * Created by dennis on 2018/3/16.
 */
public class MultiThreadSingletonC {

    private static final MultiThreadSingletonC instance = new MultiThreadSingletonC();

    private MultiThreadSingletonC(){

    }

    public static MultiThreadSingletonC getInstance(){
        return instance;
    }
}
