package me.dennis.course.p207;

/**
 * Created by dennis on 2019/1/16.
 */
public class WolfMainTest extends Animal {

    public static void info() {  // static方法不允许被重写
        System.out.println("Wolf 的 info方法");
    }

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.info();

        Animal animal1 = new WolfMainTest();
        animal1.info();

        WolfMainTest animal2 = new WolfMainTest();
        animal2.info();
    }
}

class Animal {

    public static void info(){
        System.out.println("Animal 的 info方法");
    }
}