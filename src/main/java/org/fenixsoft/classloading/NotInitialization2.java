package org.fenixsoft.classloading;

/**
 * Created by Dennis on 2017/11/16.
 * 深入java虚拟机
 * 被动调用示例1（p.172）：通过子类引用父类的静态字段，不会导致子类初始化
 */
public class NotInitialization2 {

    public static void main(String[] args){
        System.out.println(ConstClass.HELLOWORLD);
    }
}



