package jvm.chapter11;

/**
 * p.297
 * -XX:+PrintCompilation:将JVM在即时编译时将编译成本地代码的方法名称打印出来
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining:输出方法内联信息
 * -XX:+PrintCFGToFile(针对Client Compiler)::将编译过程中的文件输出到文件中
 * -XX:+PrintIdealGraphFile(针对Server Compiler):将编译过程中的文件输出到文件中
 */
public class FastDebutCompileTest {

    public static final int NUM = 15000;

    public static int doubleValue(int i){
        return i*2;
    }

    public static long calcSum(){
        long sum = 0;
        for (int i = 0; i <100 ; i++) {
            sum+=doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args){
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
