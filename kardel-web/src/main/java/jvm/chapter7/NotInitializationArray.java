package jvm.chapter7;

/**
 * 被动调用示例2（p.174）：
 *    通过数组定义来引用类，不会导致子类初始化
 *
 */
public class NotInitializationArray {

    public static void main(String[] args){
        SuperClass[] superClasses = new SuperClass[10];
    }
}

/*
 * 代码执行结果：
 *     控制台没有输出任何信息，但是字节码触发了一个名为 [Ljvm.chapter7.SuperClass
 * 类的初始化，它是一个由虚拟机自动生成的、直接继承于java.lang.Object的子类，
 * 创建动作由字节码指令newarray触发。
 *
 */

