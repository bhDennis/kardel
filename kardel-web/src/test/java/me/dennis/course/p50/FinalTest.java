package me.dennis.course.p50;

/**
 * Created by Dennis on 2018/8/27.
 */
public class FinalTest {

    public static void main(String[] args){

        // 定义4个final 宏变量
        final int a = 5 + 2;
        final double b = 1.2 /3;
        final String str = "疯狂"+"Java";
        final String book = "疯狂Java讲义:" + "99.0";

        // boo2因为调用了方法，因此无法再编译时被确定下来，不会被当做“宏变量”处理
        final String book2 = "疯狂Java讲义:" + String.valueOf(99.0);
        System.out.println(book == "疯狂Java讲义:99.0"); // 之所以相等，是因为book变量是宏变量，会被直接替换成 “疯狂Java讲义:99.0“ 这个字符串
        System.out.println(book2 == "疯狂Java讲义:99.0");
    }
}
