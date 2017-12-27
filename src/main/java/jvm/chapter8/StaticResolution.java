package jvm.chapter8;

/**
 * p.208
 *
 * Created by Dennis on 2017/12/7.
 */
public class StaticResolution {

    public static void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args){
        StaticResolution.sayHello();
    }
}
