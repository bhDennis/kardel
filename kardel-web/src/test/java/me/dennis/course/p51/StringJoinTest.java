package me.dennis.course.p51;

/**
 * Created by Dennis on 2018/8/27.
 */
public class StringJoinTest {

    public static void main(String[] args){

        String s1 = "疯狂Java";
        String s2 = "疯狂"+"Java"; //可以在编译阶段就确定其值，系统会直接让s2指向字符串池中的 “疯狂Java”字符串
        System.out.println(s1 == s2);

        // s11和s22是两个宏变量
        final String s11 = "疯狂";
        final String s22 = "Java";
        String s33 = s11 + s22; //宏变量，因此编译器可以对s11、s22执行宏替换
        System.out.println(s1 == s33);

        // str1和str2是两个字符串直接量
        String str1 = "疯狂";
        String str2 = "Java";
        String str3 = str1 + str2;
        System.out.println(s1 == str3);
    }
}
