package me.dennis.course.p108;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用不管内存是否充足，均在垃圾回收机制运行时回收对象
 * 与此类似的类还有：WeakHashMap
 */
public class WeakReferenceTest {

    public static void main(String[] args){

        // 不要写成 String str = "疯狂JAVA讲义"; 该方式定义字符串时，系统会缓存这个字符串的字符串直接量（会使用强引用来引用它），系统不会回收被缓存的字符串常量
        String str = new String("疯狂JAVA讲义");
        ReferenceQueue<String> reference = new ReferenceQueue<>();   // 创建一个引用队列
        WeakReference<String> weakReference = new WeakReference<String>(str,reference);

        // 垃圾回收后，weakReference所引用的WeakReference对象被列入ReferenceQueue，需要一个适当的清除机制，避免大量的WeakReference带来的内存泄露
        // 通过reference的poll方法来检查是否有它所管辖的非强可及对象被回收，利用它可以检查哪个WeakReference

        str = null;

        System.out.println("--内存回收前--");
        System.out.println(weakReference.get());
        System.out.println(reference.poll() == weakReference);

        /**
         * 当gc决定要收集弱引用时执行以下过程：
         *     1. 将WeakReference中的referent字段（即此处的str）设置为null，不再引用堆中的 new String("疯狂JAVA讲义") 对象
         *     2. 将堆中的new String("疯狂JAVA讲义") 对象设置为可结束的(finalizable)
         *     3. 当new String("疯狂JAVA讲义") 对象的finalize方法被运行而且该对象占用的内存被释放，weakReference被添加到它的 reference 中
         */
        // 强制垃圾回收，被引用的对象被回收后，会把被回收对象对应的引用添加到关联的引用队列中
        System.gc();
        System.runFinalization();

        System.out.println("--内存回收后--");
        System.out.println(weakReference.get());
        System.out.println(reference.poll() == weakReference);
    }
}
