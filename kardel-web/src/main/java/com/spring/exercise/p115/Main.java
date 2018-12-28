package com.spring.exercise.p115;


/**
 * Created by dennis on 2018/12/19.
 *
 */
public class Main {

    public static void main(String[] args){

        ArithmeticCalculator arithmeticCalculatorImpl = new ArithmeticCalculatorImpl();


        // 验证代理
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)
                CalculatorValidationHandler.createProxy(arithmeticCalculatorImpl);

        // 日志代理
        arithmeticCalculator = (ArithmeticCalculator)
                CalculatorLoggingHandler.createProxy(arithmeticCalculator);

        arithmeticCalculator.add(1,2);

    }
}
