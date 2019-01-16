package me.dennis.course.p150;

/**
 * Created by Dennis on 2018/12/19.
 * 静态的同步方法
 */
public class SynchronizedStaticTest implements Runnable {
    static boolean staticFlag = true;
    public static synchronized void test0(){
        for(int i=0;i<100;i++){
            System.out.println("test0:"+Thread.currentThread().getName()+""+i);
        }
    }
    public void test1(){
        synchronized (this){  // 使用this：可发现test0和test1交叉打印，替换成SynchronizedStaticTest.class时发现先打印完test0相关，后再打印test1相关，
                             // 之所以如此，是因为第一条线程已经锁定了SynchronizedStaticTest类，在第一条线程结束前不会释放对SynchronizedStaticTest的锁定
            for (int i=0;i<100;i++){
                System.out.println("test1:"+Thread.currentThread().getName()+" "+i);
            }
        }
    }
    @Override
    public void run() {
        if(staticFlag){
            staticFlag = false;
            test0();
        } else {
            staticFlag = true;
            test1();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedStaticTest synchronizedStaticTest = new SynchronizedStaticTest();
        new Thread(synchronizedStaticTest).start();
        // 保证第一条线程开始运行
        Thread.sleep(1);
        new Thread(synchronizedStaticTest).start();
    }
}