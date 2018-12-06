package me.dennis.course.p38;

/**
 * 用来分析Wolf继承Animal的字节码
 * Created by Dennis on 2018/8/20.
 */
public class Wolf extends Animal{

    private double weight;
}

class Animal {

    public String name;

    public void info(){
        System.out.println(name);
    }
}
