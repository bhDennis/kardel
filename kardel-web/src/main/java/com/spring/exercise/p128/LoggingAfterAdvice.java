package com.spring.exercise.p128;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * 后置通知：记录方法的结束以及返回的结果
 *
 * Created by dennis on 2018/12/20.
 */
public class LoggingAfterAdvice implements AfterReturningAdvice {

    private Logger logger;

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        logger.info("The method "+method.getName() + "() ends with" + returnValue);
    }
}
