package me.dennis.exercise.test;

/**
 * Created by Dennis on 2018/5/18.
 */
public class EnclosingClassA {

    static Object object = new Object(){

        public void m(){}
    };

    static Class aClass = object.getClass().getEnclosingClass();
}
