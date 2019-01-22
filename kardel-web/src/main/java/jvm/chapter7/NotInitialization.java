package jvm.chapter7;

/**
 * 被动调用示例1（p.172）：
 *      通过子类引用父类的静态字段，不会导致子类初始化
 *
 * 启动参数：-XX:+TraceClassLoading 作用：用于查看此操作是否会导致子类加载（结果：会加载子类）
 */
public class NotInitialization {

    public static void main(String[] args){
        System.out.println(SubClass.value);
    }
}



