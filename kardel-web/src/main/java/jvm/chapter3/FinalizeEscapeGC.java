package jvm.chapter3;

/**
 * p.49
 * 此代码演示两点：
 *   1.此对象可以潜在被GC时自救
 *   2.自救机会只有一次，因为一个对象的finalize方法最多只会被系统自动调用一次
 *
 * 注意：finalize方法不建议被使用，设计该方法的目的是初期为了c++程序员过渡转java，能使用finalize方法所做的工作，都可以使用try...finally完成
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){

        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {  //说明有必要执行finalize方法，稍后由一条虚拟机自动建立的低优先级的Finalizer线程触发它（p.48)
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功解救自己
        SAVE_HOOK = null;
        System.gc();

        //因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead:(");
        }

        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();

        //因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead:(");
        }
    }
}
