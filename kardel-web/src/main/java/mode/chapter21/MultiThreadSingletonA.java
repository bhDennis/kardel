package mode.chapter21;

/**
 * Created by dennis on 2018/3/16.
 */
public class MultiThreadSingletonA {

    private static MultiThreadSingletonA instance = null;

    private static final Object object = new Object();


    private MultiThreadSingletonA(){

    }

    public static MultiThreadSingletonA getInstance(){

        synchronized (object){

            if(instance == null){
                instance = new MultiThreadSingletonA();
            }
        }
        return instance;
    }
}
