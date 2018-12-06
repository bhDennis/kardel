package me.dennis.course.p130;

/**
 * Created by Dennis on 2018/12/4.
 */
public class StringEqualsTests {

    public static void main(String[] args){
        //情况一
        String str1 = "Hello World";
        String str2 = "Hello World";

        //情况二
        String str3 = "Hello" + " " + "World"; // 字符串连接表达式，该表达式的值在编译时就可确定下来，因此它指向了字符串池中的直接量

        //情况三
        String str4 = "Hello";
        String str5 = "World";
        String str6 = str4 +" "+ str5;    // 使用了变量（或者调用了方法），str6的值只能在运行时可确定，因此无法利用JVM中的字符串池

        //情况四
        final String str7 = "Hello";
        final String str8 = "World";
        String str9 = str7 + " " + str8; // str7、str8被执行了宏替换，JVM在编译时就可确定字符串连接表达式的值

        System.out.println(str1 == str2); // str1、str2两个字符串变量的值都是直接量，它们都指向JVM的字符串池里的"Hello World"字符串
        System.out.println(str1 == str3);
        System.out.println(str1 == str6);
        System.out.println(str1 == str9);

    }
}
