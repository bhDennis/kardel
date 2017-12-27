package jvm.chapter2;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * p.40
 *
 * CGLIB的原理可参考:http://blog.csdn.net/zghwaicsdn/article/details/50957474
 *
 * Created by Dennis on 2017/8/24.
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args){

        while (true){

            Enhancer enhancer = new Enhancer();  // Enhancer是CGLIB中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展

            enhancer.setSuperclass(HeapOOM.OOMObject.class); // HeapOOM.OOMObject 是被代理类，此处被设置成父类
            enhancer.setUseCache(false);


            Callback noopCb = NoOp.INSTANCE;  // 这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
            Callback callback1 = new TargetInterceptor();
            Callback fixedValue= new TargetResultFixed();
            Callback[] cbarray = new Callback[]{noopCb,callback1,fixedValue};

            CallbackFilter callbackFilter = new TargetMethodCallbackFiler();

            enhancer.setCallbacks(cbarray);
            enhancer.setCallbackFilter(callbackFilter);

            HeapOOM.OOMObject targetObject2=(HeapOOM.OOMObject)enhancer.create();
            System.out.println(targetObject2.method1("mmm1"));
            System.out.println(targetObject2.method2(100));
            System.out.println(targetObject2.method3(100));
            System.out.println(targetObject2.method3(200));
        }
    }

    static class TargetMethodCallbackFiler implements CallbackFilter{


        @Override
        public int accept(Method method) {

            if(method.getName().equals("method1")){
                System.out.println("filter method1 == 0");
                return 0;              // 返回的值决定使用哪个 Callback，比如 0->noopCb，1->callback1，2->fixedValue
            }
            if(method.getName().equals("method2")){
                System.out.println("filter method2 == 1");
                return 1;
            }
            if(method.getName().equals("method3")){
                System.out.println("filter method3 == 2");
                return 2;
            }
            return 0;
        }
    }

    static class TargetInterceptor implements MethodInterceptor{

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println("调用前");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println(" 调用后"+result);
            return result;
        }
    }

    static class TargetResultFixed implements FixedValue{

        @Override
        public Object loadObject() throws Exception {

            System.out.println("锁定结果");
            Object obj = 999;
            return obj;
        }
    }

}
