package me.dennis.exercise.test;

import java.util.concurrent.TimeUnit;

/**
 * 该示例对应的场景：
 *      当线程处于运行状态时，我们也可调用实例方法interrupt()进行线程中断，
 * 但同时必须手动判断中断状态，并编写中断线程的代码(其实就是结束run方法体的代码)。
 *
 * Created by dennis on 2019/1/14.
 */
public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    if(this.isInterrupted()){  //
                        System.out.println("未被中断");
                        break;
                    }
                }
            }
        };

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
