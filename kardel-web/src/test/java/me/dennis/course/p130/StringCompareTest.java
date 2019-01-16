package me.dennis.course.p130;

/**
 * Created by Dennis on 2018/12/4.
 */
public class StringCompareTest {

    public static void main(String[] args){

        String str1 = new String ("abc");
        String str2 = new String("z");
        String str3 = new String("abc");

        if(str1.compareTo(str3) == 0){
            System.out.println("s1和s3包含的字符序列相等");
        }
        if(str1.compareTo(str2) < 0){
            System.out.println("s1小于s2");
        }

        //通过equals比较字符串包含的字符序列是否相同
        System.out.println("s1和s3包含的字符串序列是否相同:"+str1.equals(str3));

        //通过==运算符比较两个字符串引用变量是否指向同一个字符串对象
        System.out.println("s1和s3是否指向相同的字符串:"+ (str1 == str3));

    }
}
