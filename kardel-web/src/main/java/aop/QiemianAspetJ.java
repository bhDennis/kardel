package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Dennis on 2018/8/13.
 */
@Aspect
@Component
public class QiemianAspetJ {

//    @Before("execution(* aop.*.chifan(..))")
//    public void chifanqian(){
//        System.out.println("洗手");
//        throw new RuntimeException("a");
//    }
//
//    @After("execution(* aop.*.chifan(..))")
//    public void chifanhou(){
//        System.out.println("漱口");
//    }
//
//    @Before("execution(* aop.*.shuijiao(..))")
//    public void shuijiaoqian(){
//        System.out.println("洗澡");
//    }
//
//    @AfterThrowing("execution(* aop.*.chifan(..))")
//    public void chifanhouException(){
//        System.out.println("吃饭出現异常");
//    }
//
//    @AfterReturning(value = "execution(* aop.*.chifan(..))",returning = "result")
//    public void chifanReturning(Object result){
//        System.out.println("吃饭花费"+result);
//    }

    @Around(value = "execution(* aop.*.chifan(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){

        Object obj = null;
        try {
            System.out.println("吃饭前-点菜");
            obj = proceedingJoinPoint.proceed();
            System.out.println("吃完饭-付钱"+obj);
        } catch (Throwable throwable) {
            System.out.println("吃饭出现问题");
        }
        System.out.println("吃饭后");
        return obj;
    }
}
