package me.dennis.exercise.test.threadlocal;

/**
 * http://justsee.iteye.com/blog/791919
 *
 * Created by Dennis on 2018/7/16.
 */
public class ThreadLocalTest2 {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){

        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){

        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args){

        ThreadLocalTest2 threadLocalTest2 = new ThreadLocalTest2();

        TestClient t1 = new TestClient(threadLocalTest2);
        TestClient t2 = new TestClient(threadLocalTest2);
        TestClient t3 = new TestClient(threadLocalTest2);

        t1.start();
        t2.start();
        t3.start();
    }
}

class TestClient extends Thread{

    private ThreadLocalTest2 threadLocalTest2;

    public TestClient(ThreadLocalTest2 threadLocalTest2){
        this.threadLocalTest2 = threadLocalTest2;
    }

    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println("threadName:" + Thread.currentThread().getName() + ","+threadLocalTest2+","+threadLocalTest2.getNextNum());
        }
    }
}