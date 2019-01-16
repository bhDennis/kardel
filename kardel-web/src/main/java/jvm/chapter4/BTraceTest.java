package jvm.chapter4;


import java.util.Random;

public class BTraceTest {


    public static void main(String[] args) throws Exception {
       while (true) {
            Random random = new Random();
            execute(random.nextInt(4000));
        }
    }
    public static Integer execute(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
        }
        System.out.println("sleep time is=>"+sleepTime);
        return 0;
    }
}
