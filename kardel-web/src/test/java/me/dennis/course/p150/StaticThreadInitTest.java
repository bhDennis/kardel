package me.dennis.course.p150;

/**
 * Created by Dennis on 2018/12/20.
 */
public class StaticThreadInitTest {
    static {
        //创建匿名内部类来启动新线程
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("进入run方法");
                System.out.println(website);
                website = "www.leegang.org";
                System.out.println("退出run方法");
            }
        };
        thread.start();
        try {
            thread.join();  // join()方法含义：此处只有两个线程，main线程和thread线程，表明只有当thread线程执行完毕时，main线程才能继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static String website = "www.crazyit.org";
    public static void main(String[] args){
        System.out.println(StaticThreadInitTest.website);
    }
}
