package me.dennis.exercise.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Dennis on 2018/8/20.
 */
public class GetClassTest {

    public static void main(String[] args){
//        System.out.println("--获取Class字节码对象的三种方式--");
//
//        Class classOne = Base.class;
//        Class classTwo = new Base().getClass();
//        Class classThree = null;
//        try {
//            classThree = Class.forName("me.dennis.course.p32.Base");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("classOne:"+classOne+"\n"+"classTwo:"+classTwo+"\n"+"classThree:"+classThree);
//        System.out.println("judge:"+(classOne == classTwo));
//        System.out.println("int.class==Integer.TYPE:"+(int.class==Integer.TYPE));
//        System.out.println("int.class==Integer.class:"+(int.class==Integer.class));

        // 如下方式remove会抛出java.util.ConcurrentModificationException
//        List<Integer> integerList = new ArrayList<>(6);  // Arrays.asList(3);生成的List是Arrays中的内部类，与使用new ArrayList的方式不同
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//        integerList.add(4);
//        for(Integer i : integerList){
//            if(i.equals(1)) {
//                integerList.remove(new Integer(1));
//            }
//        }

        //
        List<Integer> integerList2 = new ArrayList<>(6);  // Arrays.asList(3);生成的List是Arrays中的内部类，与使用new ArrayList的方式不同
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);
        integerList2.add(4);
        Iterator iterator = integerList2.iterator();
        List<Integer> integers = new ArrayList<>();
        while(iterator.hasNext()){
            Integer i = (Integer)iterator.next();
            if(i.equals(1)){
                integers.add(1);
            }
        }
        integerList2.removeAll(null);
        for(Integer integer : integerList2){
            System.out.println(integer);
        }
    }
}
