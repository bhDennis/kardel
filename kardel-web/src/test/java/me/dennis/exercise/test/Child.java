package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/7/5.
 */

public class Child extends Father{
    public static void main(String[] args) {
        new Child().doSomething();

    }

    public synchronized void doSomething(){
        System.out.println("child");
        super.doSomething();
    }

}

class Father {
    public synchronized void doSomething() {
        System.out.println("Father");
    }
}