package me.dennis.exercise.test;

/**
 * static代码块和构造器执行次序
 *
 * Created by dennis on 2019/1/15.
 */
public class StaticMainTest extends StaticBase {

    static{
        System.out.println("test static");
    }

    public StaticMainTest(){
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new StaticMainTest();
    }
}

class StaticBase{

    static{
        System.out.println("base static");
    }

    public StaticBase(){
        System.out.println("base constructor");
    }
}
