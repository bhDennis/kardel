package me.dennis.course.p147;

/**
 * Created by Dennis on 2018/12/14.
 */
public class StringReplaceTest {

    public static void main(String[] args){

        String clazz = "org.crazyit.auction.model.item";

        // 使用replace比较简单
        String path1 = clazz.replace(".","\\");     // 参数是普通字符序列
        System.out.println(path1);

        // 使用replaceAll复杂多了
        String path2 = clazz.replaceAll("\\.","\\\\"); // 参数是正则表达式 ,第一个参数 \\ 用于生成转义的反斜线，第二个参数 \\\\，
                                                                        // 前两条斜线生成转义的反斜线，后两条斜线生成要替换的反斜线
        System.out.println(path2);
    }
}
