package jvm.chapter9.p248;

import java.lang.reflect.Method;

/**
 * p.254
 * JavaClass执行工具
 * Created by Dennis on 2017/12/19.
 */
public class JavaClassExecuter {

    /**
     * 执行外部传过来的代表一个JAVA类的Byte数组，将输入类的byte数组中代表java.lang.System的CONSTANT_Utf8_info常量
     * 修改为劫持后的HackSystem类。
     * 将执行方法为该类的 static main(String[] args)方法，输出结果为该类向System.out/err输出的信息
     */
    public static String execute(byte[] classByte){

        HackSystem.clearBuffer();

        ClassModifier cm  = new ClassModifier(classByte);

        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","jvm/chapter9/p248/HackSystem");

        HotSwapClassLoader loader = new HotSwapClassLoader();

        Class clazz = loader.loadByte(modiBytes);

        try {

            Method method = clazz.getMethod("main",new Class[] {String[].class});

            method.invoke(null,new String[]{null});

        }catch (Throwable e){

            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
