package jvm.classloading;

/**
 * Created by Dennis on 2017/11/16.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}
