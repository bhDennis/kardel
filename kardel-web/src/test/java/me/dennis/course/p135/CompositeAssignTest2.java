package me.dennis.course.p135;

/**
 * 复合赋值运算符的陷阱 示例2
 *
 * Created by Dennis on 2018/12/5.
 */
public class CompositeAssignTest2 {

    public static void main(String[] args){

        Object he = new CompositeAssignTest2();
        String crazy = "cra.org ,";

        crazy += he;
        System.out.println(crazy);

        he += crazy;
        System.out.println(he);
    }
}
