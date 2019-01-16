package me.dennis.exercise.test;

/**
 * Created by dennis on 2018/7/17.
 */
public class ThreadLocalExtTest {

    public static int i = 1;

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args){

    }
}
