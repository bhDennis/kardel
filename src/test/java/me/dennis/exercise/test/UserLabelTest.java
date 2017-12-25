package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserLabelTest {

    @Autowired
    private UserLabel userLabel;

    @Test
    public void customLabel(){
        System.out.println("user:"+userLabel);
    }

    final AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void test() throws InterruptedException {

        testConcurrently();
        Thread.sleep(500);// 需要延迟如300ms会打印出自增后的值，不延迟会输出错误的值，因为test本身是一个线程，而自增是多个线程，test线程可能会早于自增中的某个线程输出，这只是假象看起来自增是错的
        System.out.println("count:"+counter.get());

    }

    @Test
    public void testConcurrently(){

        for (int i = 0; i < 264; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.incrementAndGet();
                    System.out.println("线程name:"+Thread.currentThread().getName()+"----i:"+counter.get());

                }
            }).start();
        }
    }

}
