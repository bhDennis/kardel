package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/3/15.
 */
public class AA extends AbstractA{

    public AA(){
        System.out.println("实例化AA");
    }

    static {
        System.out.println("AA静态代码块");
    }
}
