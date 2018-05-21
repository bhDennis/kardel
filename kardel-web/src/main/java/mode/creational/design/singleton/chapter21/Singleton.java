package mode.creational.design.singleton.chapter21;

/**
 * 线程不安全式的单例模式
 * Created by dennis on 2018/3/16.
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){

        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
