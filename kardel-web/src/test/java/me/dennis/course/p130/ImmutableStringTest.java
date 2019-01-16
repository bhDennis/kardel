package me.dennis.course.p130;

/**
 * Created by Dennis on 2018/12/4.
 */
public class ImmutableStringTest {

    public static void main(String[] args){

        // 情况一 ,identityHashCode方法来获取某个对象的唯一hashCode值，下面三次输出str，其对应的hashCode值均不相同
        String str = "Hello";
        System.out.println(System.identityHashCode(str)); //

        str = str + "Java";
        System.out.println(System.identityHashCode(str));

        str = str + ",crazyit.org";
        System.out.println(System.identityHashCode(str));

        System.out.println("----------------");

        // 情况二 ,下面三次输出stringBuilder，其对应的hashCode值均相同
        StringBuilder stringBuilder = new StringBuilder("Hello ");
        System.out.println(System.identityHashCode(stringBuilder));

        stringBuilder.append("Java");
        System.out.println(System.identityHashCode(stringBuilder));

        stringBuilder.append(",crazyit.org");
        System.out.println(System.identityHashCode(stringBuilder));
    }
}
