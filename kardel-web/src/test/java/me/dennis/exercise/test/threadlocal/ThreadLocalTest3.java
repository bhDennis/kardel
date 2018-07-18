package me.dennis.exercise.test.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dennis on 2018/7/16.
 */
public class ThreadLocalTest3 {

    private static final Map<DatePattern,ThreadLocal<DateFormat>> map;

    static {
        DatePattern[] patterns = DatePattern.values();
        int len = patterns.length;
        map = new HashMap<>();

        for(int i=0;i<len;i++){
            DatePattern datePattern = patterns[i];
            final String pattern = datePattern.pattern;
            map.put(datePattern,new ThreadLocal<DateFormat>(){
                @Override
                protected DateFormat initialValue() {
                    return new SimpleDateFormat(pattern);
                }
            });
        }
    }

    public static DateFormat getDateFormat(DatePattern datePattern){
        ThreadLocal<DateFormat> threadLocalFormat = map.get(datePattern);
        return threadLocalFormat.get();
    }

    public static void main(String[] args){

        Thread threadOne = new Thread(){
            @Override
            public void run() {
                System.out.println("threadName:"+Thread.currentThread().getName()+","+ThreadLocalTest3.getDateFormat(DatePattern.DATE_PATTERN));
            }
        };

        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                System.out.println("threadName:"+Thread.currentThread().getName()+","+ThreadLocalTest3.getDateFormat(DatePattern.DATE_PATTERN));
            }
        };

        Thread threadThree = new Thread(){
            @Override
            public void run() {
                System.out.println("threadName:"+Thread.currentThread().getName()+","+ThreadLocalTest3.getDateFormat(DatePattern.DATE_PATTERN));
            }
        };

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}

enum DatePattern{

    TIME_PATTERN("yyyy-MM-dd HH:mm:ss"),
    DATE_PATTERN("yyyy-MM-dd");

    String pattern;

    DatePattern(String pattern){
        this.pattern = pattern;
    }
}