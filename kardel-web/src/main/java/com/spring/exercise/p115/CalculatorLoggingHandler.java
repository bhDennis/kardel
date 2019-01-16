package com.spring.exercise.p115;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by dennis on 2018/12/19.
 *
 * 作用：记录方法起始和结束的调用处理程序（日志代理）
 */
public class CalculatorLoggingHandler implements InvocationHandler {

    private Logger logger; // 后续接入日志

    private Object target;

    public CalculatorLoggingHandler(Object target){
        this.target = target;
    }

    /**
     *
     * @param proxy     代理实例
     * @param method    当前正被调用的方法
     * @param args      目标方法的参数数组
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("The method "+method.getName()+"() begins with"+ Arrays.toString(args));

        Object result = method.invoke(target,args);

        logger.info("The method+"+method.getName()+"() ends with"+result);

        return result;
    }

    /**
     *
     * 创建一个具有调用处理程序的JDK动态代理实例
     *
     * newProxyInstance方法：
     *
     *  第一个参数 --> 类加载器，负责注册该代理，绝大部分情况下该类加载器就是原始类的类加载器
     *  第二个参数 --> 由该代理需要实现的接口组成，通常需要代理目标类的所有接口
     *  第三个参数 --> 处理方法调用的处理程序
     *
     *  返回值：得到JDK动态创建的一个代理实例
     */
    public static Object createProxy(Object target){

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorLoggingHandler(target));
    }
}
