package me.dennis.course.p135;

/**
 * 复合赋值运算符的陷阱
 *
 * Created by Dennis on 2018/12/5.
 */
public class CompositeAssignTest {

    public static void main(String[] args){

        short st = 5; // short类型的范围 -32768~32768
        st+=10;
        System.out.println(st);

        st+=90000;
        System.out.println(st); // 应该输出90010，但由于溢出，被高位截断
    }
}
