package me.dennis.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dennis on 2018/5/5.
 */
public class CollectionToArrayTest {

    public static void main(String[] args){

        Collection collection1 = new ArrayList(15);

        collection1.add("000");
        collection1.add("111");
        collection1.add("222");

        System.out.println("collection1.大小:"+collection1.size());
        System.out.println("collection1.内容:"+collection1);
    }

    public static void methodA(){

    }

    public static int a = 1;
    public void methodB(){
        this.methodA(); // 非静态方法中可以访问静态方法
        int b = this.a; // 非静态方法中可以访问静态变量
    }
}
