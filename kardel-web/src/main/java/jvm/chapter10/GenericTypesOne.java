package jvm.chapter10;

import java.util.List;
/**
 *     p.270
 *    下面的重载方法无法编译执行。
 *    原因1：List<String>和 List<Integer>编译后都被擦除了，
 * 变成了一样的原生类型List<E>,擦除动作导致这两个方法的特征签名
 * 一模一样。
 *
 * Created by Dennis on 2017/12/27.
 */
public class GenericTypesOne {

//    public static void method(List<String> list){
//
//        System.out.println("invoke method(List<String> list)");
//    }
//
//    public static void method(List<Integer> list){
//
//        System.out.println("invoke method(List<Integer> list)");
//    }
}
