package com.spring.exercise.p115;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dennis on 2018/12/20.
 *
 * 作用：参数不能小于0（验证代理）
 */
public class CalculatorValidationHandler implements InvocationHandler {

    private Object target;

    public CalculatorValidationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        for (Object arg : args){
            validate((Double) arg);
        }

        Object object = method.invoke(target,args);

        return object;
    }

    public static Object createProxy(Object target){

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorValidationHandler(target));
    }

    private void validate(Double arg) {
        if(arg < 0)
            throw new IllegalArgumentException("Positive numbers only");
    }
}
