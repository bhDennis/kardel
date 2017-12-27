package org.fenixsoft.classloading;

/**
 * Created by Dennis on 2017/11/16.
 * 深入java虚拟机
 * 被动调用示例2（p.174）：通过数组定义来引用类，不会导致子类初始化
 */
public class NotInitializationExt {

    public static void main(String[] args){
        SuperClass[] superClasses = new SuperClass[10];
    }
}

/*
 代码执行结果，控制台没有输出任何信息，但是字节码触发了一个名为 [Lorg.fenixsoft.classloading.SuperClass
 的类的初始化阶段，它是一个由虚拟机自动生成的、直接继承于java.lang.Object的子类，创建动作由字节码指令
 newarray触发。
*/

