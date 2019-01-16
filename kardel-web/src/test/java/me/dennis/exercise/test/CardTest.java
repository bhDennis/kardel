package me.dennis.exercise.test;

import java.util.*;

/**
 * Map排序
 * 可参考：https://www.cnblogs.com/zhujiabin/p/6164826.html
 * Created by Dennis on 2018/8/15.
 */
public class CardTest {

    public static void main(String[] args){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(13,1);
        map.put(16,2);
        map.put(1,3);
        map.put(2,4);

        for(Integer key : map.keySet()){
            System.out.println("key->value:"+key+":"+map.get(key));
        }
        System.out.println("--排序方式1后--");

        //方式1 默认使用key（此处的Integer类的compareTo的方法）
        map = new TreeMap<>(map);
        for(Integer key : map.keySet()){
            System.out.println("key->value:"+key+":"+map.get(key));
        }

       //方式2 实现默认比较器
       List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getKey()).compareTo(o2.getKey());
            }
        });
        System.out.println("--排序方式2后--");
        for(Integer key : map.keySet()){
            System.out.println("key->value:"+key+":"+map.get(key));
        }
    }

    private static Map<Integer,String> sortMapByKey(Map<Integer, String> map) {

        if(map == null || map.isEmpty())
            return null;

        return null;
    }
}
