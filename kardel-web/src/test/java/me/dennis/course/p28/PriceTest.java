package me.dennis.course.p28;

/**
 * 第一次用到Price类时，程序开始对Price类进行初始化，分为两个阶段：
 *  1.  系统为Price的两个类变量分配内存空间
 *  2.  按照初始化代码（定义时指定初始块中执行初始值）的排列顺序对类变量执行初始化。
 *      一、初始化第一阶段instance和initPrice的初始值是null和0.0。
 *      二、初始化第二个阶段,对instance赋值要调用Price(2.8)，创建Price实例，此时构造器中的initPrice值为0.0。
 *
 * Created by Dennis on 2018/8/13.
 */
public class PriceTest {

    public static void main(String[] args){

        System.out.println(Price.instance.currentPrice);

        Price price = new Price(2.8);

        System.out.println(price.currentPrice);
    }
}

class Price{

    final static Price instance = new Price(2.8);

    static double initPrice = 20; //添加final导致输出不同的结果

    double currentPrice;

    public Price(double disCount){

        currentPrice = initPrice - disCount;
    }
}
