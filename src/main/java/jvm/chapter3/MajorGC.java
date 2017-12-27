package jvm.chapter3;

/**
 * 大对象直接进入老年代
 *
 * p.68
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+HeapDumpOnOutOfMemoryError
 *
 * -XX:PretenureSizeThreshold=3145728 只对 Serial和ParNew收集器有效
 */
public class MajorGC {

    private static final int _IMB = 1024 * 1024;

    public void testPretenureSizeThreshold(){

        byte[] allocation4;

        allocation4 = new byte[6 * _IMB];
    }

    public static void main(String[] args){

        MajorGC minorGC = new MajorGC();
        minorGC.testPretenureSizeThreshold();
    }
}

