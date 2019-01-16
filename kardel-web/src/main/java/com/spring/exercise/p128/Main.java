package com.spring.exercise.p128;

import com.spring.exercise.p115.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dennis on 2018/12/20.
 */
public class Main {

    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        ArithmeticCalculator arithmeticCalculatorProxy = (ArithmeticCalculator)applicationContext.getBean("arithmeticCalculatorProxy");

        arithmeticCalculatorProxy.add(1,2);
    }
}
