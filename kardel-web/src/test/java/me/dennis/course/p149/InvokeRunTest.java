package me.dennis.course.p149;

/**
 * Created by Dennis on 2018/12/17.
 *
 * 线程的启动要通过start方法，
 * 调用run方法是不会启动一条新线程的，与调用普通Java对象的普通方法是无区别的
 */
public class InvokeRunTest {

    public static void main(String[] args){

        for (int i=0;i<100;i++){

            // 调用Thread.currentThread()获取当前线程
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 20){
                // 直接调用线程对象的run方法
                // 系统会把线程对象当成普通对象，把run方法当成普通方法，所以下面两行代码并不会启动2条线程，而是依次执行2个run方法
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}

class InvokeRun extends Thread{

    private int i;

    @Override
    public void run() {

        for(;i<100;i++){

            // 直接调用run方法时，Thread的this.getName返回该对象名字，而不是当前线程的名字
            // Thread.currentThread().getName()总是获取当前线程名字
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
