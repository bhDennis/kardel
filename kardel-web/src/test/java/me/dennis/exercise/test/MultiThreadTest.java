package me.dennis.exercise.test;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by Dennis on 2018/4/19.
 */
public class MultiThreadTest {


    public static void main(String[] args){

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    }
}


 class MultiThreadDemo implements Runnable{

    private Integer id;

    public void MultiThreadDemo(Integer id){
         this.id = id;
    }

    @Override
    public void run() {

        System.out.println("run:"+id);
    }
}
