package me.dennis.course.p99;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 对于HashSet，TreeSet等Set集合：
 *
 *     遍历最后一个元素时，删除任意元素，不会引发ConcurrentModification异常。
 *     遍历其他元素时，删除任意元素，会引发该异常。
 *
 * Created by Dennis on 2018/10/25.
 */
public class TreeSetRemoveTest {

    public static void main(String[] args){

        TreeSet<String> stringTreeSet = new TreeSet<String>();
        stringTreeSet.add("111");
        stringTreeSet.add("222");
        stringTreeSet.add("333");
        System.out.println("移出前:"+stringTreeSet);

        for(Iterator<String> iterator = stringTreeSet.iterator();iterator.hasNext();){
            String ele = iterator.next();
            if(ele.equals("333")){
                stringTreeSet.remove(ele);
            }
        }
        System.out.println("移出后:"+stringTreeSet);
    }
}
