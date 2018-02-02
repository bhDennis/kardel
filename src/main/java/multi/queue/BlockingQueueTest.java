package multi.queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    //定义装苹果的篮子
    class Basket {

        BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

        public void produce() throws InterruptedException {
            basket.put("An apple");
        }

        public String consume() throws InterruptedException {
            return basket.take();
        }
    }

    class Producer implements Runnable {

        private String instance;
        private Basket basket;

        public Producer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("生产者准备生产苹果" + instance);
                    basket.produce();
                    System.out.println("生产者生产苹果完毕" + instance);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted");
            }
        }
    }

    class Consumer implements Runnable {

        private String instance;
        private Basket basket;

        public Consumer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("消费者准备消费苹果" + instance);
                    System.out.println(basket.consume());
                    System.out.println("消费者消费苹果完毕" + instance);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer Interrupted");
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueTest test = new BlockingQueueTest();
        Basket basket = test.new Basket();//建立一个苹果的篮子
        ExecutorService exec = Executors.newCachedThreadPool();

        //两个生产者
        Producer producer = test.new Producer("生产者001", basket);
        Producer producer2 = test.new Producer("生产者002", basket);

        //一个消费者
        Consumer consumer = test.new Consumer("消费者001", basket);

        //开启任务
        exec.submit(producer);
        exec.submit(producer2);
        exec.submit(consumer);

        //程序运行5s后，所有任务停止
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
    }
}
