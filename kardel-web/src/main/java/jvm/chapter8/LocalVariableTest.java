package jvm.chapter8;

/**
 * p.202
 *
 * Created by Dennis on 2017/12/6.
 */
public class LocalVariableTest {

//    /**
//     * 情形一：
//     *
//     * 执行结果： 运行System.gc()后并没有回收掉这64M内存
//     * 原因：可以理解为 回收时placeHolder还处于作用域内
//     * @param args
//     */
//    public static void main(String[] args){
//
//        byte[] placeHolder = new byte[64*1024*1024];
//
//        System.gc();
//    }

    /**
     * 情形二：
     *
     * 执行结果： 运行System.gc()后并没有回收掉这64M内存
     *
     * 原因：placeHolder的作用域已经被限制在花括号中，但是依然没有回收掉
     *
     * @param args
     */
    public static void main(String[] args){

        {
            byte[] placeHolder = new byte[64*1024*1024];   placeHolder = null;
        }

        System.gc();
    }

//    /**
//     * 情形三：
//     *   将代码修改如下，发现64M被回收掉了
//     *
//     * @param args
//     */
//    public static void main(String[] args){
//
//        {
//            byte[] placeHolder = new byte[64*1024*1024];
//        }
//
//        int a = 0;
//        System.gc();
//    }
}
