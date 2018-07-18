package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/7/18.
 */
public class BaseTest {

    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * 获取Class对象的第一种方式，执行的时候，不会自动初始化，可以发现Base中的static块不会打印出来
         */
        Class clazz = Base.class;

        /**
         * 获取Class对象的第二种方式，执行的时候，会自动初始化该Class对象，static块中内容会打印出来
         */
        Class clazzt = Class.forName("me.dennis.exercise.test.Base");
    }
}

class Base{

    static int num = 1;

    static {
        System.out.println("Base"+num);
    }
}
