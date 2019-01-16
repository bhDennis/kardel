package me.dennis.course.p114;

import me.dennis.course.p108.Person;

import java.util.HashSet;
import java.util.Set;
/**
 * 当集合里面的属性被修改后，再调用remove方法是不起作用
 */
public class MemoryLeakCollection2Test {

    public static void main(String[] args){

        Set<Person> set = new HashSet<>();
        Person p1 = new Person("唐僧",25);
        Person p2 = new Person("孙悟空",26);
        Person p3 = new Person("猪八戒",27);

        set.add(p1);
        set.add(p2);
        set.add(p3);

        for(Person p : set){
            System.out.println(p);
        }
        System.out.println("元素总数:"+set.size());
        p3.setAge(2);  // 此时p3元素对应的hashCode值发生改变，可以查看Person的字节码查看其hashCode方法

        /**
         * HashSet.remove方法 --> HashMap.remove方法 --> HashMap.removeNode方法，
         * 查看源码，tab[index = (n - 1) & hash])
         * 假设p3元素是所在的index = 9,该值是基于p3元素的hash计算得到的。
         *
         * 该行代码中元素的index是在add方法时确定的，对应此处的 p20行，但是在 p27行执行后，
         * 该对象p3的hashCode值已经发生改变，从而hash也会发生改变，remove时得到的index = 8,
         * 而table[8]位置上的元素为空，所以remove方法的返回值是false。
         *
         * 第二次add方法还能添加成功，原因如下：第一个p3对象是放在(猪八戒,27)这些参数决定的hash位置上，
         * 第二次添加的p3对象是放在(猪八戒,2)这些参数决定的hash位置上.
         *
         * 如上remove失败会发生 “内存泄露”。
         */
        boolean isRemoveSuccess = set.remove(p3);
        set.add(p3);
        System.out.println("元素总数:"+set.size() +",isRemoveSuccess:"+isRemoveSuccess);

        for(Person p : set){
            System.out.println(p);
        }
    }
}
