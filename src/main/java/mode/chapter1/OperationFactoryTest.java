package mode.chapter1;

import java.util.Scanner;

/**
 * 简单工厂模式(p.22~47)
 */
public class OperationFactoryTest {

    public static void main(String[] args){

        System.out.println("--请输入第一个数字--");
        Scanner scanner = new Scanner(System.in);

        int _numberA = scanner.nextInt();

        System.out.println("--请输入第二个数字--");
        int _numberB = scanner.nextInt();

        System.out.println("--请输入符号位--");
        String flag = scanner.next();

        Operation operation = OperationFactory.createOperation(flag);
        operation.set_numberA(_numberA);
        operation.set_numberB(_numberB);
        double result = operation.getResult();

        System.out.println("结果是："+result);
    }
}
