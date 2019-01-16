package algorithm.chapter2;

/**
 * 最大公约数：两个整数的最大公约数是同时整除二者的最大整数。
 *
 * p.35
 *
 * Created by dennis on 2018/6/4.
 */
import java.util.ArrayList;
public class Gcd {

    public static long gcd(long m,long n){

        while(n!=0){

            long rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
}
