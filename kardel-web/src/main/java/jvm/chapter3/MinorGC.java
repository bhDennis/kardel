package jvm.chapter3;

/**
 * MinorGC 即指 新生代GC
 * p.67
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class MinorGC {

    private static final int _IMB = 1024 * 1024;

    public void testAllocation(){

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _IMB];

        allocation2 = new byte[2 * _IMB];

        allocation3 = new byte[2 * _IMB];

        allocation4 = new byte[4 * _IMB];  //出现一次 Minor GC
    }

    public static void main(String[] args){

        MinorGC minorGC = new MinorGC();
        minorGC.testAllocation();
    }
}
