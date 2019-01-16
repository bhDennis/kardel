package me.dennis.exercise.test;

import java.util.concurrent.TimeUnit;

/**
 * 该示例对应的场景：
 *    一种是当线程处于阻塞状态或者试图执行一个阻塞操作时，
 * 我们可以使用实例方法interrupt()进行线程中断，执行中断操作
 * 后将会抛出interruptException异常(该异常必须捕捉无法向外抛出)并将中断状态复位
 *
 * Created by dennis on 2019/1/14.
 */
public class InterruptSleepThread3 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(){
            @Override
            public void run() {

                try {
                    while (true){
                        // 当前线程处于阻塞状态，异常必须捕捉处理，无法往外抛出
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                   System.out.println("Interrupted when sleep");
                   boolean interrupt = this.isInterrupted();
                   System.out.println("interrupt:"+interrupt); // 抛出异常时中断状态已被复位
                }
            }
        };

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();//中断处于阻塞状态的线程
    }
}
