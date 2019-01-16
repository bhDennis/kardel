package me.dennis.course.p135;

/**
 * Created by Dennis on 2018/12/12.
 * 泛型陷阱（p.144)
 */
public class ErasureTest2 {

    public static void main(String[] args){

        Apple<Integer> a = new Apple<Integer>(6);

        for(String apple :a.getApples()) {
            System.out.println(apple);
        }

        Apple b = a; // a变量赋给没有泛型的变量b，系统将擦除所有泛型信息，也就是说 b.getApples() 不再返回List<String> ,而是返回List，所以提示“不兼容的类型”编译错误
//        for(String apple:b.getApples()){
//            System.out.println(apple);
//        }
    }
}

