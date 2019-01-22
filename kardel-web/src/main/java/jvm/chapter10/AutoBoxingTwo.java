package jvm.chapter10;

/**
 * 自动装箱的陷进 --- p.274
 *
 * 包装类的 “==”在没有遇到算数运算符的情况下不会自动拆箱。
 *
 * Created by Dennis on 2017/12/27.
 */
public class AutoBoxingTwo {

    public static void main(String[] args){

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
                                                 // 执行前猜测  --->   执行后结果（JDK8环境下）

        System.out.println(c == d);             // false ---> true    说明进行了拆箱
        System.out.println(e == f);            // false ---> false    说明在 在某个临界点值时，不会再进行拆箱
        System.out.println(c == (a+b));       // false ---> true      说明进行了拆箱
        System.out.println(c.equals(a+b));   // true   ---> true      查看Integer类的equals方法可知进行了拆箱
        System.out.println(g == (a+b));     // false   ---> true      说明进行了拆箱，且进行了类型转换
        System.out.println(g.equals(a+b)); //  true ---> false         a+b后不是Long类型，具体原因可查看Long类的equals方法
    }
}
