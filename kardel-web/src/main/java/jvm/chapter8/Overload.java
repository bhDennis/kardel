package jvm.chapter8;

import java.io.Serializable;

/**
 * 静态分派
 *
 * p.212
 *
 * Created by Dennis on 2017/12/7.
 */
public class Overload {

    public static void sayHello(Object arg){
        System.out.println("hello Oject");
    }

    public static void sayHello(int arg){
        System.out.println("hello int");
    }

    public static void sayHello(long arg){
        System.out.println("hello long");
    }


    public static void sayHello(Character arg){
        System.out.println("hello Character");
    }

    public static void sayHello(char arg){
        System.out.println("hello char");
    }

    public static void sayHello(char ... arg){
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg){
        System.out.println("hello Serializable ...");
    }

    public static void sayHello(Comparable<Character> arg1){
        System.out.println("hello Comparable...");
    }

    public static void main(String[] args){

        sayHello("a");
    }
}