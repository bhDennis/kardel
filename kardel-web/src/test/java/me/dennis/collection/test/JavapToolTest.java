package me.dennis.collection.test;

/**
 * Created by Dennis on 2018/8/1.
 */
public class JavapToolTest {

    {
        count = 12;
    }
    int count = 20;

    public JavapToolTest(){
        count = 39;
        System.out.println(count);
    }

    public JavapToolTest(String name){
        System.out.println(name);
    }

    public static void main(String[] args){
        new JavapToolTest();
    }
}
