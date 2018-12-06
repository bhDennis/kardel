package me.dennis.course.p52;

/**
 * final修饰变量
 *
 * Created by Dennis on 2018/8/27.
 */
public class FinalInitTest {

    //普通变量
    final String str1;
    final String str2;
    final String str3 = "Java";     //对于实例变量而言，在定义时、非静态初始块、构造器中给变量赋值的效果是一样的；对于final变量但是效果是不同的，只有在定义时才会进行宏替换

    {
        str1 = "Java";
    }
    public FinalInitTest(){
        str2 = "Java";
    }
    public void display(){
        System.out.println("普通变量:"+(str1 + str1 == "JavaJava"));
        System.out.println("普通变量:"+(str2 + str2 == "JavaJava"));
        System.out.println("普通变量:"+(str3 + str3 == "JavaJava"));
    }

    // 类变量
    final static String s1;
    final static String s2 = "Java";
    static {
        s1 = "Java";
    }

    public static void main(String[] args){
        FinalInitTest finalInitTest = new FinalInitTest();
        finalInitTest.display();
        System.out.println("类变量:"+(s1+s1 == "JavaJava"));
        System.out.println("类变量:"+(s2+s2 == "JavaJava"));
    }

}
