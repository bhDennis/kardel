package me.dennis.course.p99;

import me.dennis.exercise.test.Gendar;

import java.util.*;

/**
 * p.97
 * Created by Dennis on 2018/10/24.
 */
public class IteratorTest {

    public static void main(String[] args){

        HashSet<String> hashSet = new HashSet<>();
        System.out.println("HashSet的iterator:"+hashSet.iterator());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        System.out.println("LinkedHashSet的iterator:"+linkedHashSet.iterator());

        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println("TreeSet的iterator:"+treeSet.iterator());

        EnumSet<Gendar> enumSet = EnumSet.allOf(Gendar.class);
        System.out.println("EnumSet的iterator:"+enumSet.iterator());

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("ArrayList的iterator:"+arrayList.iterator());

        Vector<String> vector = new Vector<>();
        System.out.println("Vector的iterator:"+vector.iterator());

        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println("LinkedList的iterator:"+linkedList.iterator());

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        System.out.println("ArrayDeque的iterator:"+arrayDeque.iterator());
    }
}
