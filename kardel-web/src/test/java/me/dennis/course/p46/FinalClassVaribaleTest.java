package me.dennis.course.p46;

/**
 * Created by Dennis on 2018/8/23.
 */
public class FinalClassVaribaleTest {

    final static int var1 = "疯狂Java讲义".length();

    final static int var2;

    static {
        var2 = "轻量级Java EE企业应用实战".length();
    }

    public static void main(String[] args){

        final String localVar3 = "局部变量";    //final修饰局部变量
        System.out.println(FinalClassVaribaleTest.var1);
        System.out.println(FinalClassVaribaleTest.var2);
        System.out.println(localVar3);
    }
}
