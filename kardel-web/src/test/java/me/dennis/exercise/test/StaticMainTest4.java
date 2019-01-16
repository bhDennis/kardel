package me.dennis.exercise.test;

/**
 *
 * Created by dennis on 2019/1/15.
 */
public class StaticMainTest4 {

    Book book1 = new Book("book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");
    private static int a = 2;
    public StaticMainTest4(String msg) {
        System.out.println(msg);
    }

    // 静态方法只有在类名.方法名 调用时才可以输出，而静态变量在加载类时会输出
    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }

    static {
        System.out.println("---static代码块--");
        System.out.println("--a:--"+a);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4 = new Book("static成员book4成员变量初始化");

    public static void main(String[] args) {
        StaticMainTest4.funStatic();
        System.out.println("****************");
        StaticMainTest4 p1 = new StaticMainTest4("p1初始化");
    }
}


class Book{
    public Book(String msg) {
        System.out.println(msg);
    }
}