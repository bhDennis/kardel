package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/3/15.
 */
public abstract class AbstractA {

    public AbstractA(){
        System.out.println("AbstractA实例化");
    }

    static {
        System.out.println("AbstractA静态代码块");
    }
}
