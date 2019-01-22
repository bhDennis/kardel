package jvm.chapter10;
import java.util.ArrayList;
import java.util.List;

/**
 *     p.271
 *     书本中的示例可以运行，可能是JDK版本问题，当前IDEA
 * 是 JDK8。
 *     方法重载要求具备不同的特征签名，返回值并不包含
 * 在方法的特征签名中，因此返回值不参与重载选择，这里依然不能
 * 共存。
 *
 */
public class GenericTypesTwo {

//    public static String method(List<String> list){
//
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }
//
//    public static int method(List<Integer> list){
//
//        System.out.println("invoke method(List<Integer> list)");
//        return 1;
//    }
//
//    public static void main(String[] args){
//        method(new ArrayList<String>());
//        method(new ArrayList<Integer>());
//    }
}
