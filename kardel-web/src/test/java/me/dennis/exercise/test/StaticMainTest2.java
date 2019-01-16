package me.dennis.exercise.test;

/**
 * Created by dennis on 2019/1/15.
 */
public class StaticMainTest2 {

    StaticBase2 person = new StaticBase2("StaticMainTest2");
    static{
        System.out.println("test static");
    }

    public StaticMainTest2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class StaticBase2{
    static{
        System.out.println("person static");
    }
    public StaticBase2(String str) {
        System.out.println("person "+str);
    }
}

class MyClass extends StaticMainTest2 {

    StaticBase2 person = new StaticBase2("MyClass");
    static{
        System.out.println("myClass static");
    }

    public MyClass() {
        System.out.println("myClass constructor");
    }
}


