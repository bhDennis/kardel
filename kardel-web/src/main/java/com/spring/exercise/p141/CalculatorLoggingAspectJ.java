package com.spring.exercise.p141;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

/**
 * Created by dennis on 2018/12/23.
 * 前置通知切面
 */
@Aspect
public class CalculatorLoggingAspectJ {

    private Logger logger;

    /**
     * 这里的 * 表示匹配任意修饰符(pubic,protected 和 private)及返回类型
     * 参数中的两个点表示匹配任意数量的参数
     *
     * 这个切入点表达式表示执行ArithmeticCalculator接口的add方法
     */
    @Before("execution(* ArithmeticCalculator.add(..))")
    public void logBefore(){
        logger.info("The method add() begins");
    }
}
