package jvm.chapter4;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Strings.str;
import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.timeMillis;

/**
 * Created by Dennis on 2017/9/21.
 */
@BTrace
public class TraceBTraceTest {

    @TLS
    private static long startTime = 0;

    @OnMethod(clazz = "jvm.chapter4.BTraceTest", method = "execute")
    public static void startMethod(){
        startTime = timeMillis();
    }

    @OnMethod(clazz = "jvm.chapter4.BTraceTest", method = "execute", location = @Location(Kind.RETURN))
    public static void endMethod(){
        println(strcat("the class method execute time=>", str(timeMillis()-startTime)));
        println("-------------------------------------------");
    }

    @OnMethod(clazz = "jvm.chapter4.BTraceTest", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(@ProbeClassName String name, @ProbeMethodName String method, int sleepTime){
        println(strcat("the class name=>", name));
        println(strcat("the class method=>", method));
        println(strcat("the class method params=>", str(sleepTime)));

    }
}
