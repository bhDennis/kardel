package me.dennis.course.p73;

import java.util.HashSet;
import java.util.Set;

/**
 * 当试图把某个类的对象作为HashMap的key，或者试图将该类的对象放入HashSet中保存时，
 * equals方法和hashCode方法都要重写。
 * 当该类的两个hashCode返回值相同时，它们通过equals比较也应该返回true。
 * 通常来说，所有参与计算hashCode返回值的关键属性，都应该用于作为equals方法的比较标准。
 */
public class HashSetContainsTest {
    public static void main(String[] args){
        Set<Name> set = new HashSet<Name>();
        set.add(new Name("abc","123"));
        System.out.println(set.contains(new Name("abc","123")));
    }
}

class Name{

    private String first;
    private String last;
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj.getClass() == Name.class){
            Name n = (Name)obj;
            return n.first.equals(((Name) obj).first) && n.last.equals(((Name) obj).last);
        }
        return false;
    }
//    根据first计算Name对象的hashCode值
    @Override
    public int hashCode() {
        return first.hashCode();
    }
}
