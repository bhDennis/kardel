package com.spring.exercise.p115;


/**
 * Created by dennis on 2018/12/19.
 *
 * 需求1：为每个计算器增加限制，只处理正数
 * 解决方式是为写个validate方法，add、sub等方法开头调用
 *
 * 需求2：记录每个方法的调用参数以及返回结果
 * 解决方式是引入log4j，即在每个方法前后打印日志
 *
 *  ...
 *
 *  基于上述越来越多的需求
 *
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public double add(double a, double b) {

        double result = a+b;
        System.out.print(a+"+"+b+"="+result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a-b;
        System.out.print(a+"-"+b+"="+result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a * b;
        System.out.print(a+"*"+b+"="+result);
        return result;
    }

    @Override
    public double div(double a, double b) {

        if(b == 0)
            throw new IllegalArgumentException("Division by Zero");

        double result = a / b;
        System.out.print(a+"/"+b+"="+result);
        return result;
    }
}
