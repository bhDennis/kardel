package jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOOM :  p.33  Java堆内存异常测试
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

        public String method1(String paramName) {
            return paramName;
        }
        public int method2(int count) {
            return count;
        }
        public int method3(int count) {
            return count;
        }

        @Override
        public String toString() {
            return "OOMObject []"+ getClass();
        }
    }

    public static void main(String[] args){

        int i = 0;
        List<OOMObject> list = new ArrayList<>();

//        System.out.println(Runtime.getRuntime().freeMemory());

        while(true){
            list.add(new OOMObject());
            System.out.println("i:"+i++);
        }
    }
}

// 年轻代：eden  8192K -> 8M  2个survivor -> 各1M  年老代: 10m

