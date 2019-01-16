package me.dennis.course.p135;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Dennis on 2018/12/12.
 * 泛型陷阱（p.142)
 */
public class ErasureTest{

    public static void main(String[] args){

        Apple<Integer> a = new Apple<Integer>(6);
        Integer as = a.getSize();
        Apple b = a; // 当把一个具有泛型信息的对象赋给另一个没有泛型信息的变量时，所有在尖括号之间的类型信息都将被丢弃

        Number size1 = b.getSize();
//        Integer size2 = b.getSize();//b只知道size的对象是Number，因此赋值给Integer类型的size时会引起编译报错
    }
}

