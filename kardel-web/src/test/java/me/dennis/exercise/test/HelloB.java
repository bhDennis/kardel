package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/3/21.
 */
public class HelloB extends HelloA{

    public HelloB(){
        System.out.println("HelloB");
    }
    {
        System.out.println("I'm B class");
    }
    static {
        System.out.println("static B");
    }

    public static void main(String[] args){
        new HelloB();
    }

    // static A ,static B,I'm A class,HelloA,I'm B class,HelloB
}

class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm A class");
    }
    static {
        System.out.println("static A");
    }
}
