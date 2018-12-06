package me.dennis.course.p135;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Dennis on 2018/12/6.
 */
public class RawTypeTest {

    public static void main(String[] args){

        //创建一个RawType的List集合
        List list = new ArrayList();
        list.add("疯狂Java讲义");
        list.add("轻量级Java EE企业应用实战");
        list.add("疯狂Ajax讲义");

        //将原始类型的list集合赋给带泛型声明的List集合
        List<Integer> integers = list;
        for(int i=0;i<integers.size();i++){

             //情况一：可正常输出
            //System.out.println(integers.get(i));

            //情况二：integers集合本身就是List<Integer>类型的，因此编译时不会有问题，但运行时会抛出ClassCastException异常
            Integer in = integers.get(i);
            System.out.println(in);

            //情况三：会出现编译错误,试图将Integer的值赋值给String类型变量
            //String in = integers.get(i);
            //System.out.println(in);
        }
    }
}
