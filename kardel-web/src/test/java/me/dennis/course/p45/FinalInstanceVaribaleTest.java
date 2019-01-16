package me.dennis.course.p45;

/**
 * 给final变量赋值的三种方式
 * Created by Dennis on 2018/8/22.
 */
public class FinalInstanceVaribaleTest {

    final int var1 = "疯狂讲义".length(); //1.定义的时候指定初始值
    final int var2;
    final int var3;
    {
        var2 = "轻量级".length();  //2.非静态初始块中指定初始值
    }

    public FinalInstanceVaribaleTest(){
        this.var3 = "疯狂讲义".length();//3.构造器中指定初始值
    }

    public static void main(String[] args){

        FinalInstanceVaribaleTest fiv = new FinalInstanceVaribaleTest();
        System.out.println(fiv.var1);
        System.out.println(fiv.var2);
        System.out.println(fiv.var3);
    }
}
