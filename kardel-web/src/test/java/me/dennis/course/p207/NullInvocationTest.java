package me.dennis.course.p207;

/**
 * Created by dennis on 2019/1/16.
 */
public class NullInvocationTest {

    public static void main(String[] args){

        NullInvocationTest nullInvocationTest = null;
        nullInvocationTest.info();  // 能正常编译执行说明static方法的调用会转换为NullInvocationTest类来调用
    }

    public static void info(){
        System.out.println("--info--");
    }
}
