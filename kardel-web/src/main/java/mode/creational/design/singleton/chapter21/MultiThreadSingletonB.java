package mode.creational.design.singleton.chapter21;

/**
 * Created by dennis on 2018/3/16.
 */
public class MultiThreadSingletonB {

    private static MultiThreadSingletonB instance = null;

    private static final Object object = new Object();

    private MultiThreadSingletonB(){

    }

    public static MultiThreadSingletonB getInstance(){

        if(instance == null){

            synchronized (object){

                if(instance == null){
                    instance = new MultiThreadSingletonB();
                }
            }
        }
        return instance;
    }
}
