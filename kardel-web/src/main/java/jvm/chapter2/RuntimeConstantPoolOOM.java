package jvm.chapter2;
import java.util.ArrayList;
import java.util.List;

/**
 * p.39
 *
 * -XX:PermSize=3M -XX:MaxPermSize=3M
 * JAVA 8中已经去掉了方法区（或永久代） 这个区域
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();  // 使用list保持常量池的引用，避免Full GC回收常量池的行为

        short  i = 0;                             //  i是局部变量，存储于 虚拟机栈中

        while (true){

            list.add(String.valueOf(i++).intern()); // String.valueOf(i++).intern() 的内容 存储于 运行时常量池，即方法区（或永久代）中
        }

    }
}
