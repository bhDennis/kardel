package com.spring.exercise.p128;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 前置通知
 * Created by dennis on 2018/12/20.
 */
public class LoggingBeforeAdvice implements MethodBeforeAdvice {

    private Logger logger;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        logger.info("The method "+method.getName() + "() begins with" + Arrays.toString(args));
    }
}
