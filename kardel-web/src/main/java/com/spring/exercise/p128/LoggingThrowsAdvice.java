package com.spring.exercise.p128;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 异常通知
 * ThrowsAdvice 这个接口里没有声明任何方法，这样就可以在不同的方法里处理不同类型的异常了。
 * Spring规定：每个处理异常的方法名必须是 afterThrowing，异常的类型由方法的参数类型决定
 *
 * Created by dennis on 2018/12/20.
 */
public class LoggingThrowsAdvice implements ThrowsAdvice {

    private Logger logger;

    /**
     * 处理 IllegalArgumentException 异常的方法
     * 在异常通知里的方法签名中，前三项（Method,Object[],Object)是可选的，要么一起声明，要么一个都不声明
     * @param exception
     */
    public void afterThrowing(Method method, Object[] args,Object target,IllegalArgumentException exception){

       logger.info("illegal exception" + Arrays.toString(args) + "for method "+ method.getName() +"()");
    }
}
