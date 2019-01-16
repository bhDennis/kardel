package me.dennis.course.p108;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用示例（通过改变数组的长度来查看）
 * 内存不足时回收
 */
public class SoftReferenceTest {

    public static void main(String[] args){

        ReferenceQueue<Person> reference = new ReferenceQueue<>();   // 创建一个引用队列
        SoftReference<Person>[] people = new SoftReference[500];

        for(int i=0;i<people.length;i++){
            people[i] = new SoftReference<Person>(new Person("名字"+i,(i+1)*4%100),reference);
        }
        System.out.println("--内存回收前--");
        System.out.println(people[2].get());
        System.out.println(people[4].get());


        // 通知系统进行垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println("--内存回收后--");
        System.out.println(people[2].get()); // 如果输出值代表内存充足
        System.out.println(people[4].get());
    }
}


