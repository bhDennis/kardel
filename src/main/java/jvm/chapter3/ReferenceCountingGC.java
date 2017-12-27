package jvm.chapter3;

/**
 *
 * p.45
 *
 * 引用计数器算法
 *
 * 目的：testGC方法执行后，referenceCountingGCA、referenceCountingGCB是否会被GC
 *
 * -XX:+PrintGCDetails
 *
 * 结果：并不会因为互相引用就不回收这两个对象
 *
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _IMB = 1024 * 1024;

    private byte[] bigSize = new byte[2*_IMB]; //意义就是占用一点内存，以便能在GC日志中查看是否被回收

    public static void testGC(){

        ReferenceCountingGC referenceCountingGCA = new ReferenceCountingGC();

        ReferenceCountingGC referenceCountingGCB = new ReferenceCountingGC();

        referenceCountingGCA.instance = referenceCountingGCB;

        referenceCountingGCB.instance = referenceCountingGCA;

        referenceCountingGCA = null;

        referenceCountingGCB = null;

        System.gc();
    }

    public static void main(String[] args){

        testGC();
    }
}
