package me.dennis.course.p99;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 对于ArrayList，Vector，LinkedList等List集合：
 *
 *     遍历倒数第2个元素时，删除任意元素，不会引发ConcurrentModification异常。
 *     遍历其他元素时，删除任意元素会引发该异常。
 *
 * Created by Dennis on 2018/10/24.
 */
public class ArrayListRemoveTest {

    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        linkedList.iterator();
        list.add("111");
        list.add("222");
        list.add("333");
        for(Iterator<String> iterator = list.iterator();iterator.hasNext();){
            String ele = iterator.next();
            if(ele.equals("111")){
                System.out.println(ele);
                list.remove("333");
            }
        }
        System.out.println(list);
    }
}
