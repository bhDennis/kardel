package jvm.chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型擦除前的例子 p.269
 *
 * Created by Dennis on 2017/12/27.
 */
public class GenericTest {

    public static void  main(String[] args){

        Map<String,String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("how are you","吃了没");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you"));
    }
}
