package me.dennis.exercise.test;

/**
 * Created by dennis on 2019/1/15.
 */
public class StaticMainTest3 {

    static{
        System.out.println("test static 1");
    }
    public static void main(String[] args) {

        System.out.println("test main");
    }

    static{
        System.out.println("test static 2");
    }
}
