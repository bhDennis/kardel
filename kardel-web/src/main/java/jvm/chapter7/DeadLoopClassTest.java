package jvm.chapter7;

/**
 * p.188 --
 *
 * 针对<clinit>方法的下面这个点进行验证：
 *      虚拟机会保证<clinit>方法在多线程环境中正确的被加锁和同步。
 * 当存在多个线程同时去初始化一个类时，那么只会有一个类执行<clinit>方法，其他线程均需要阻塞等待
 *
 * 一条线程正在死循环以模拟长时间操作，另外一条线程在阻塞等待
 *
 *
 * Created by dennis on 2019/1/22.
 */
public class DeadLoopClassTest {

    static class DeadLoopClass{

        static {
            if(true){     // 如果去掉if语句，会拒绝编译
                System.out.println(Thread.currentThread()+" init DeadLoopClass");
                while (true){

                }
            }
        }
    }

    public static void main(String[] args){

        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread()+"run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        System.out.println("thread1:"+thread1);
        System.out.println("thread2:"+thread2);
        thread1.start();
        thread2.start();
    }
}


