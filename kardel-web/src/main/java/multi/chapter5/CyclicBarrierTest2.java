package multi.chapter5;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Dennis on 2018/6/19.
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1 + Thread.currentThread().getName());
            }
        }).start();

        try {
            c.await();      //在主线程上等待，该行代码必须有
        } catch (Exception e) {

        }
        System.out.println(2 + Thread.currentThread().getName());
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3 + Thread.currentThread().getName());
        }
    }
}
