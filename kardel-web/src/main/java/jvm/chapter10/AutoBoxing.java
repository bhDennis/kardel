package jvm.chapter10;
import java.util.Arrays;
import java.util.List;
/**
 * 自动装箱、拆箱与遍历循环 ---p.273
 *
 * 对比看源码和反编译工具后的代码
 *
 * Created by Dennis on 2017/12/27.
 */
public class AutoBoxing {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4);
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        System.out.println(sum);
    }
}
