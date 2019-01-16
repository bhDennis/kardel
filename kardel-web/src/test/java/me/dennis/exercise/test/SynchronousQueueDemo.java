package me.dennis.exercise.test;

import java.util.concurrent.SynchronousQueue;

/**
 * 从停顿时间可以看出 queue.put(1)后就被阻塞了
 * Created by Dennis on 2018/6/25.
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        producerThread.start();
        Thread.sleep(1000);
        consumerThread.start();


//        consumerThread.start();
//        Thread.sleep(1000);
//        producerThread.start();

    }
}
