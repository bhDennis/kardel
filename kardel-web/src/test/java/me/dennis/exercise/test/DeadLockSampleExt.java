package me.dennis.exercise.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程死锁示例
 * Created by dennis on 2018/6/17.
 */
public class DeadLockSampleExt extends Thread{

        private String first;
        private String second;
        public DeadLockSampleExt(String name, String first, String second) {
            super(name);
            this.first = first;
            this.second = second;
        }

        public  void run() {
            synchronized (first) {
                System.out.println(this.getName() + " obtained: " + first);
                try {
                    Thread.sleep(1000L);
                    synchronized (second) {
                        System.out.println(this.getName() + " obtained: " + second);
                    }
                } catch (InterruptedException e) {
                    // Do nothing
                }
            }
        }
        public static void main(String[] args) throws InterruptedException {

            ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
            Runnable dlCheck = new Runnable() {

                @Override
                public void run() {
                    long[] threadIds = mbean.findDeadlockedThreads();
                    if (threadIds != null) {
                        ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
                        System.out.println("Detected deadlock threads:");
                        for (ThreadInfo threadInfo : threadInfos) {
                            System.out.println(threadInfo.getThreadName());
                        }
                    }
                }
            };

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            // 稍等 5 秒，然后每 10 秒进行一次死锁扫描
            scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);

            String lockA = "lockA";
            String lockB = "lockB";
            DeadLockSampleExt t1 = new DeadLockSampleExt("Thread1", lockA, lockB);
            DeadLockSampleExt t2 = new DeadLockSampleExt("Thread2", lockB, lockA);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
}
