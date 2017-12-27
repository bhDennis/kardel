package jvm.chapter4;
import java.util.ArrayList;
import java.util.List;


/**
 * P.90  JConsole监视代码
 *
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * 代码含义:以64KB/50ms的速度向java堆中填充数据，一共填充1000此。
 */
public class OOMObjectTest {

    /**
     * 内存占位符对象：一个OOMBject大小约为 64k
     */
   static class OOMObject {

       public byte[] placeholder = new byte[64 * 1024];
   }

   public static void fileHeap(int num) throws InterruptedException {


       List<OOMObject> list = new ArrayList<>();

       for(int i = 0;i<num; i++){

           Thread.sleep(50);  //稍作延迟，令监视曲线的变化更加明显

           list.add(new OOMObject());
       }
       System.gc();

   }
   public static void main(String[] args) throws InterruptedException {

//       fileHeap(1000);

       for(int i = 0;i<10;i++){
           Thread.sleep(1000);
           System.out.print("i am test");
       }
   }
}
