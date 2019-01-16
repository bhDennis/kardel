package jvm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * p.72 线程等待演示
 *
 */
public class BusyThreadTest {

    //线程死循环
    public static void createBusyThread(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    ;
                }
            }
        },"testBusyThread");

        thread.start();
    }

    // 线程锁等待
    public static void createLockThread(final Object lock){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock){

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");

        thread.start();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();// 显示在readBytes方法中等待System.in的键盘输入，此时线程为Runnable状态，Runnable状态的进程会被分配运行时间，但readBytes方法检查到没有更新时会立刻归还执行令牌，这种等待只消耗很小的CPU资源

        createBusyThread();//当输入后，从堆栈中看到进入到该方法，且可以观察到一直停留在20行，该行为while(true)，这时候线程为Runnable状态，而且没有归还执行令牌的动作，会在空循环上用尽全部执行时间直到线程切换，这种等待会消耗较多的CPU资源

        bufferedReader.readLine();//当在命令行上输入后，会进入的到 createLockThread方法

        Object object = new Object();

        createLockThread(object);//testLockThread线程此时处于WAITING状态，处于正常的活锁等待，只有lock对象的notify或notifyAll被调用，便可以激活以继续运行，在被唤醒前不会分配运行时间

    }
}
