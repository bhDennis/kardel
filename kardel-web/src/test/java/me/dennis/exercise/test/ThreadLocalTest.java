package me.dennis.exercise.test;

/**
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 *
 * Created by Dennis on 2017/10/17.
 *
 *
 */
public class ThreadLocalTest {

    private static ThreadLocal<Long> longLocal = new ThreadLocal<>();
    private static ThreadLocal<String> stringLocal = new ThreadLocal<>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {

        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        threadLocalTest.set();
        System.out.println("before-main-编号"+threadLocalTest.getLong());
        System.out.println("before-main-名称"+threadLocalTest.getString());
        System.out.println("before-main-对象引用"+threadLocalTest.stringLocal.hashCode());
        System.out.println("before-main-值对象String引用"+threadLocalTest.stringLocal.get().hashCode());
        System.out.println();

        Thread thread1 = new Thread(){
            public void run() {
                threadLocalTest.set();
                threadLocalTest.stringLocal.set("私有线程");
                /**
                 *  此处改了stringLocal里对象的值，结合打印出的对象引用也不相同，
                 *  且after-main-名称处打印出的值并不是私有线程，更近一步说明只是一份拷贝，但每个线程持有的
                 *  ThreadLocal引用值是完全相同的。
                 */
                System.out.println("thread1-编号"+threadLocalTest.getLong());
                System.out.println("thread1-名称"+threadLocalTest.getString());
                System.out.println("thread1-对象引用"+threadLocalTest.stringLocal.hashCode());
                System.out.println("thread1-值对象String引用"+threadLocalTest.stringLocal.get().hashCode());
                System.out.println();
            };
        };
        thread1.start();
        thread1.join();

        System.out.println("after-main-编号"+threadLocalTest.getLong());
        System.out.println("after-main-名称"+threadLocalTest.getString());
        System.out.println("after-main-对象引用"+threadLocalTest.stringLocal.hashCode());
        System.out.println("after-main-值对象String引用"+threadLocalTest.stringLocal.get().hashCode());
    }
}
