package me.dennis.collection.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * Created by Dennis on 2018/7/28.
 */
public class MapTest {

    public static void main(String[] args){

        Map<String,String> map = new HashMap<>();

        System.out.println(map.get(null));

        List<Integer> integerList = Arrays.asList(0,10,1,2,8,9);
        System.out.println(integerList.stream().reduce(12,(a,b)->Integer.max(a,b))); // reduce用于比较输出最大值
    }
}
