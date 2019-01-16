package jvm.chapter3;

/**
 * 长期存活的对象进入老年代
 *
 * MaxTenuringThreshold 表示對象的年龄达到多少时晋升老年代
 *
 * p.70
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 */
public class MaxTenuringGC {

    private static final int _IMB = 1024 * 1024;

    public void testAllocation(){

        byte[] allocation1,allocation2,allocation3;

        allocation1 = new byte[ _IMB/4]; //什么时候进入老年取决于 XX:MaxTenuringThreshold设置

        allocation2 = new byte[4 * _IMB];

        allocation3 = new byte[4 * _IMB];

        allocation3 = null;

        allocation3 = new byte[4 * _IMB];

    }

    public static void main(String[] args){

        MaxTenuringGC minorGC = new MaxTenuringGC();
        minorGC.testAllocation();
    }
}
