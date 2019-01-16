package me.dennis.course.p108;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 *
 * 垃圾回收后，只有虚引用引用的字符串对象将会被垃圾回收，当被引用的对象被回收后，对应引用将被添加到关联的引用
 * 队列中。
 *
 * 使用这些引用类可以避免程序在执行期间将对象留在内存中，如果以软引用、弱引用或虚引用的方式引用对象，
 * 垃圾回收器可以随意地释放对象，从而减小程序在其生命周期中所占用的内存大小。
 *
 */
public class PhantomReferenceTest {

    public static void main(String[] args){

        String str = new String("疯狂JAVA讲义");
        ReferenceQueue<String> reference = new ReferenceQueue<>();   // 创建一个引用队列
        PhantomReference<String> phantomReference = new PhantomReference<>(str,reference); // 创建一个虚引用，让它指向 “疯狂JAVA讲义"字符串

        str = null;

        // 试图取出该虚引用引用的对象，程序并不能通过虚引用访问被引用的对象，此处输出null
        System.out.println("--内存回收前--");
        System.out.println(phantomReference.get());
        System.out.println(reference.poll() == phantomReference); // 虚引用在对象被释放前，将把它对应的虚引用添加到它的关联引用队列中

        // 垃圾回收
        System.gc();
        System.runFinalization();

        // 取出引用队列中最先进入队列中引用与phantomReference进行比较
        System.out.println("--内存回收后--");
        System.out.println(phantomReference.get());
        System.out.println(reference.poll() == phantomReference);

    }
}
