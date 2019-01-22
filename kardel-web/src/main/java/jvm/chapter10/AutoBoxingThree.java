package jvm.chapter10;
import java.util.Arrays;
import java.util.List;

/**
 * 包含了泛型、自动装箱、自动拆箱、遍历循环、变长参数五个语法糖
 *
 * 具体查看字节码
 *
 * Created by dennis on 2019/1/17.
 */
public class AutoBoxingThree {

    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,2,3,4);

        int sum = 0;
        for(int i : list){
            sum+=i;
        }
        System.out.println(sum);
    }
}
