package jvm.chapter7;

/**
 * 下面字段a1，a2，a3在字节码中的表现方式都一样,static且final的
 *
 * Created by dennis on 2019/1/18.
 */
public interface InitializationInterface {

    public int a1 = 1;

    public static int a2 = 2;

    public static final int a3 = 3;

}
