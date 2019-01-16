package jvm.chapter2;

/**
 * StackOOM:  p.37  创建线程导致OOM
 *
 * 运行如下代码会造成操作系统假死，因为windows平台的虚拟机中，java
 * 线程是映射到操作系统的内核线程上的。
 */
public class StackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){

        while (true){

//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//                    dontStop();
//                }
//            };
//            thread.start();
        }
    }

    public static void main(String[] args){

        StackOOM stackOOM = new StackOOM();
        stackOOM.stackLeakByThread();
    }
}
