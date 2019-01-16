package com.spring.exercise.p128;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 环绕通知
 *   所有通知里最为强大的类型，它可以控制方法的执行过程，可以控制是否以及何时继续执行原始的方法。
 *   它可以改变原始方法的参数值，以及最终的返回结果。
 *
 *
 * Created by dennis on 2018/12/20.
 */
public class LoggingAroundAdvice implements MethodInterceptor {

    private Logger logger;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        logger.info("The method "+invocation.getMethod().getName() + "() begins with" + Arrays.toString(invocation.getArguments()));

        try {

            Object result = invocation.proceed();

            logger.info("The method "+invocation.getMethod().getName() + "() ends with" + result);

            return result;

        } catch (Exception e){

            logger.info("illegal exception" + Arrays.toString(invocation.getArguments()) + "for method "+ invocation.getMethod().getName() +"()");

        }

        return null;
    }
}
