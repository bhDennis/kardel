package me.dennis.exercise.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 2018/7/18.
 */
public class ThreeStoogesTest {

    int num1 = 1+num2;
    static int num2 = 2;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private String[] strArray = new String []{"1","2"};

    public static void main(String[] args){

//        ThreeStooges threeStooges = new ThreeStooges();
//        System.out.println(threeStooges.isStooge("Moe"));
//        threeStooges.set();
//        System.out.println(threeStooges.isStooge("HZX"));

//        List<String> a = new ArrayList<>();
//        System.out.println(a.get(0));

          System.out.println(EMPTY_ELEMENTDATA);

          System.out.println(DEFAULTCAPACITY_EMPTY_ELEMENTDATA);

          System.out.println(EMPTY_ELEMENTDATA == DEFAULTCAPACITY_EMPTY_ELEMENTDATA);

        int[][] inArray = new int[3][4];

        System.out.println(inArray.length);

        System.out.println(Object.class);

        System.out.println(Object[].class == Object[].class);

        new ThreeStoogesTest().print();
    }

    {
        i = 9;
    }
    int i = 2;

    public void print(){
        System.out.println(i);
    }
}
