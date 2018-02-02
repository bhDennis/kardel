package jvm.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * p.239
 *
 * Created by Dennis on 2017/12/15.
 */
public class DynamicProxyTest {

    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{

        @Override
        public void sayHello() {

            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        Object originalObj;

        Object bind(Object originalObj){

            this.originalObj = originalObj;
            System.out.println("bind,classLoader:"+originalObj.getClass().getClassLoader());
            System.out.println("bind,interfaces:"+originalObj.getClass().getInterfaces());
            System.out.println("bind,this:"+this);
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args){

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
