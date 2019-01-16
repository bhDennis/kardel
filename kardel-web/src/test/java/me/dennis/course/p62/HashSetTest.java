package me.dennis.course.p62;

import java.util.HashSet;

/**
 * Created by Dennis on 2018/9/14.
 */
public class HashSetTest {

    public static void main(String[] args){

        HashSet hashSet = new HashSet();

        System.out.println(hashSet.hashCode());

        Object hashSet1 = hashSet.clone();

        System.out.println(hashSet1.hashCode());

        Object hashSet2 = new HashSet();

        System.out.println(hashSet2.hashCode());
    }
}
