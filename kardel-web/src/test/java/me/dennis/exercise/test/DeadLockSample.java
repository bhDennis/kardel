package me.dennis.exercise.test;

/**
 * 线程死锁示例
 * Created by dennis on 2018/6/17.
 */
public class DeadLockSample extends Thread{

        private String first;
        private String second;
        public DeadLockSample(String name, String first, String second) {
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
            String lockA = "lockA";
            String lockB = "lockB";
            DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
            DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
            t1.start();
            t2.start();
            t1.join();//让线程进入等待状态
            t2.join();
        }
}
