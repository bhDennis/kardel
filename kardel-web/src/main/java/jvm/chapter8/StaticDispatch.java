package jvm.chapter8;

/**
 * 静态分派
 *
 * p.209
 *
 * Created by Dennis on 2017/12/7.
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human{

    }

    static class Women extends Human{

    }

    public void sayHello(Human guy){
        System.out.println("hello,guy!");
    }

    public void sayHello(Man man){
        System.out.println("hello,man!");
    }

    public void sayHello(Women women){
        System.out.println("hello,women!");
    }

    public static void main(String[] args){

        Human man = new Man();  // 把Human称为变量的静态类型或者外观类型  Man称为变量的实际类型 详见p.211
        Human women = new Women();

        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(women);
    }
}

/**
 * 编译器在判断使用哪个重载方法时，是通过参数的静态类型而不是实际类型来判断的。
 */
