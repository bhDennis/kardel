package jvm.chapter2;

/**
 * StackSof:  p.36  栈深度异常测试
 *
 * 单线程的前提下，测试 StackOverflowError 异常
 */
public class StackSof {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){

        StackSof stackSof = new StackSof();

        try {
            stackSof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+stackSof.stackLength);
            e.printStackTrace();
        }
    }
}
