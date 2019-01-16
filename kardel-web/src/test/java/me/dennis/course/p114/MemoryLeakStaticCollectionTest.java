package me.dennis.course.p114;

import java.util.Vector;

/**
 * 释放了引用本身，但是Vector仍然引用该对象，所以这个对象对GC来说是不可回收的。
 * 因此，如果对象加入到Vector后，还必须从Vector中删除，最简单的方式是将vector置为null
 */
public class MemoryLeakStaticCollectionTest {


    static Vector vector = new Vector(10);

    public void operateVector(){

        for(int i=1;i<10;i++){
            Object o = new Object();
            vector.add(o);
            o = null;
        }
    }
}
