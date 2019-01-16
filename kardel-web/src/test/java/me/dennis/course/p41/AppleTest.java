package me.dennis.course.p41;

import java.util.Arrays;
import java.util.List;

/**
 * super的作用是什么？
 *
 * Created by Dennis on 2018/8/21.
 */
public class AppleTest extends Fruit{

    @Override
    public void info() {
        System.out.println("Apple方法");
    }

    public void accessSuperInfo(){
        super.info();
    }

    public Fruit getSuper(){
        return super.getThis();
    }

    String color = "红色";

    public static void main(String[] args){

//        AppleTest appleTest  = new AppleTest();
//        Fruit fruit = appleTest.getSuper();//其实质返回的是Apple对象
//        System.out.println("appleTest==fruit:"+(appleTest==fruit)); // false
//        System.out.println("appleTest.color:"+appleTest.color+",fruit.color:"+fruit.color);// 红色 未确定颜色
//        appleTest.info(); //Apple方法
//        fruit.info();//Fruit方法
//        appleTest.accessSuperInfo();//Fruit方法

        List<String> BRAND_NAME = Arrays.asList("苹果","荣耀");
        boolean isBrandApple = "张安卓".indexOf(BRAND_NAME.get(0)) == -1;
        System.out.println(isBrandApple);
    }
}


class Fruit{

    String color = "未确定颜色";
    public Fruit getThis(){
        return this;         //直接返回调用该方法的对象
    }
    public void info(){
        System.out.println("Fruit方法");
    }
}