package me.dennis.course.p147;

/**
 * Created by Dennis on 2018/12/14.
 * 正则表达式的陷阱（p.147)
 */
public class StringSplitTest {

    public static void main(String[] args){

        String str = "java.is.funny.www.crazyit.org";
        String[] strArray = str.split("."); // 注意：split中的参数是正则表达式 ，其中.可匹配任意字符，可换成 \\ . 实现想要的分隔效果
        for(String s : strArray){
            System.out.println(s);
        }
    }
}

// 之所以输出如下结果，是因为(.)可以匹配任意字符，所以上面程序实际上不是以(.)作为分隔符，而是以任意字符作为分隔符，为了以(.)作为分隔符，必须对点号进行转义