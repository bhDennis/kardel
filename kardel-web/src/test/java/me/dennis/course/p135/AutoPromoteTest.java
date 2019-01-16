package me.dennis.course.p135;

/**
 * 表达式类型的自动提升陷阱
 *
 * Created by Dennis on 2018/12/5.
 */
public class AutoPromoteTest {

    public static void main(String[] args){

        // 情况一:
        short sValue = 5;
//      sValue = sValue - 2; // 该行代码无法编译。算术表达式的类型提升到int型，但是将其赋给short类型的sValue会发生错误

        // 情况二:
        byte b = 40;
        char c = 'a';
        int i = 23;
        double d = .314;
        double result = b + c + i *d;
        System.out.println(result);

        // 情况三:
        int val = 3;
        int intResult = 23/val;        // val是int型，因此表达式也是int型
        System.out.println(intResult);

        // 情况四:（程序自动将7,a等基本类型转换为字符串）
        System.out.println("Hello!"+'a'+7); // 基本类型的值和String进行连接运算时，系统会将基本类型的值转换为String类型

        // 情况五:（程序将a当成int处理）
        System.out.println('a'+7+"Hello");
    }
}
