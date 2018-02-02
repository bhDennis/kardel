package jvm.classloading;

/**
 * Created by Dennis on 2017/11/16.
 */
public class SuperClass {

    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}
