package me.dennis.course.p145;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Dennis on 2018/12/13.
 * Java不支持创建泛型数组（p.146）
 */
public class GenericArrayTest {

    public static void main(String[] args){


//        // 下面待实际是不被允许的
//        List<String>[] lsa = new List<String>[0];
//
//        //向上转换为一个Object[]
//        List[] os = lsa;
//
//        //创建一个集合
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//
//        //将List<Integer>对象作为oa的第二个元素
//        //下面代码不会有警告
//        os[1] = li;
//
//        //下面代码也不会有警告，但是会引起ClassCastException
//        String s = lsa[1].get(0);
//
//        List[] lsa2 = new List[0];
    }
}
