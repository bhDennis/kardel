package jvm.chapter7;

/**
 * 被动调用示例2（p.172）：
 *     常量在编译阶段会存入调用类的常量池中，本质是没有直接引用到定义常量的类，
 * 因此不会触发定义常量的类的初始化
 *
 *  HELLO_WORLD常量的值在编译阶段存入了 NotInitializationConst 类的常量池中，
 *  此处对 ConstClass.HELLO_WORLD 的调用转换为 NotInitializationConst
 *  类对自身常量池的引用，即NotInitialization2的class文件之中并没有
 *  ConstClass类的符号引用入口。
 */
public class NotInitializationConst {

    public static void main(String[] args){
        System.out.println(ConstClass.HELLO_WORLD);
    }

    public static void initializationStatic(){
        System.out.println("initializationStatic");
    }
}



