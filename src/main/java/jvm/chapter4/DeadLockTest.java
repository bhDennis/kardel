package jvm.chapter4;


/**
 * p.94  死锁代码示例
 */
public class DeadLockTest {

    public static void main(String[] args){

        for(int i = 0;i<100;i++){

            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }
}


class SynAddRunnable implements Runnable{

    int a,b;

    public SynAddRunnable(int a,int b){
        this.a = a;
        this.b = b;
    }

    /**
     * 出现死锁的情形：
     *    在某个线程的两个synchronized块之间发生了一次线程切换，
     * 会出现线程A等待被线程B持有的Integer.valueOf(1)，线程B又等着被线程A持有的Integer.valueOf(2)
     */
    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){       //死锁原因：Integer.valueOf方法基于减少对象创建次数和节省内存的考虑，[-128,127)之间的数字会被缓存，当valueOf方法在该范围内传入参数，就直接返回缓存中的对象，
            synchronized (Integer.valueOf(b)){  //也就是说，即使代码调用了200次Integer.valueOf方法一共就只返回了两个不同的对象
                System.out.println(a+b);
            }
        }
    }
}
