package mode.behavior.design2.strategy.chapter2;

import java.util.Scanner;

public class CashContextTest {

    public static void main(String[] args){

        System.out.println("--1.正常收费--");
        Scanner scanner = new Scanner(System.in);

        double money = scanner.nextDouble();
        CashContext cashContext = new CashContext("normal");

        double result = cashContext.getResult(money);
        System.out.println("result:"+result);



        System.out.println("--2.满300减100-");
        scanner = new Scanner(System.in);

        money = scanner.nextDouble();
        cashContext = new CashContext("300 rebate 100");

        result = cashContext.getResult(money);
        System.out.println("result:"+result);



        System.out.println("--3.打八折-");
        scanner = new Scanner(System.in);

        money = scanner.nextDouble();
        cashContext = new CashContext("80%");

        result = cashContext.getResult(money);
        System.out.println("result:"+result);

    }
}
