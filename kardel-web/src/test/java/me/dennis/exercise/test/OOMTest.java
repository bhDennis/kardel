package me.dennis.exercise.test;

import java.util.ArrayList;

/**
 * Created by dennis on 2018/11/1.
 */
public class OOMTest {

    static class Obj{
        public byte[] bytes = "hello everyone".getBytes();
    }

    public static void main(String[] args){

        ArrayList<Obj> objArrayList = new ArrayList<>();
        while (true)
            objArrayList.add(new Obj());
    }
}
