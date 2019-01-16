package me.dennis.course.p145;

/**
 * Created by Dennis on 2018/12/14.
 */
public class GenericArrayTest2<T> {

    class A<T>{
        T foo;
    }

    public GenericArrayTest2(){
        A[] as = new A[10];
    }
}
