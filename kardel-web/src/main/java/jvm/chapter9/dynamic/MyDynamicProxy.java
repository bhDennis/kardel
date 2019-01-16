package jvm.chapter9.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理：它的原理是通过实现和目标类的同一个接口的方式，因此无法转换为原始目标类。
 *
 * CGLIB代理：采取的是创建目标类的子类的方式，因为是子类化，可以达到近似使用被调用者本身的效果。
 *
 * Created by Dennis on 2018/5/19.
 */
public class MyDynamicProxy {

    public static void main(String[] args){

        Hello hello = new HelloImpl();

        MyInvocationHandler handler = new MyInvocationHandler(hello);

        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),handler);

        proxyHello.sayHello();
    }
}

interface Hello{

    void sayHello();
}

class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object target;

    public MyInvocationHandler(Object target){

        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoking say hello");

        Object result = method.invoke(target,args);

        return result;
    }
}
