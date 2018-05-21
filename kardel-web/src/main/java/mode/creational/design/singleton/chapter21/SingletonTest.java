package mode.creational.design.singleton.chapter21;

/**
 * Created by dennis on 2018/3/16.
 */
public class SingletonTest {

    public static void main(String[] args){

        Singleton instance1 = Singleton.getInstance();

        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
