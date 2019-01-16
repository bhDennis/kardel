package me.dennis.course.p62;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 将一个Set集合扩展为Map,当一个Set中的集合元素都是SimpleEntry对象时，该
 * Set就变成了一个Map集合。
 * Debug用于阅读resize方法
 * Created by Dennis on 2018/9/3.
 */
public class HashSetToMapTest {

    public static void main(String[] args){

        HashMap hashMap = new HashMap();
        System.out.println(hashMap.size());

        hashMap.put("a","a");
        System.out.println(hashMap.size());

        hashMap.put("b","b");
        System.out.println(hashMap.size());

        hashMap.put("c","c");
        System.out.println(hashMap.size());

        hashMap.put("d","d");
        System.out.println(hashMap.size());

        hashMap.put("e","e");
        System.out.println(hashMap.size());

        hashMap.put("f","f");
        System.out.println(hashMap.size());

        hashMap.put("h","h");
        System.out.println(hashMap.size());

        hashMap.put("i","i");
        System.out.println(hashMap.size());

        hashMap.put("j","j");
        System.out.println(hashMap.size());

        hashMap.put("k","k");
        System.out.println(hashMap.size());

        hashMap.put("l","l");
        System.out.println(hashMap.size());

        hashMap.put("m","m");
        System.out.println(hashMap.size());

        hashMap.put("n","n");
        System.out.println(hashMap.size());
    }

    private void testSimpleEntry(){

        Set2Map<String,Integer> scores = new Set2Map<>();
        scores.put("语文",89);
        scores.put("数学",83);
        scores.put("英语",80);

        System.out.println("集合列表元素:"+scores);
        System.out.println("大小:"+scores.size());
        scores.removeEntry("数学");
        System.out.println("删除key=数学后集合列表元素:"+scores.size());
        System.out.println("语文成绩:"+scores.get("语文"));
        System.out.println("是否包含英语key:"+scores.containsKey("英语"));
        System.out.println("是否包含82value:"+scores.containsValue(82));
        scores.clear();
        System.out.println("清空后,集合列表元素:"+scores.size());
    }
}

class SimpleEntry<K,V> implements Map.Entry<K,V>,java.io.Serializable{

    private final K key;

    private V value;

    public SimpleEntry(K key,V value){
        this.key = key;
        this.value = value;
    }

    public SimpleEntry(Map.Entry<? extends K,? extends V> entry){

        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {

        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public boolean equals(Object o){

        if(o == this){
            return true;
        }
        if(o.getClass() == SimpleEntry.class){
            SimpleEntry se = (SimpleEntry)o;
            return se.getKey().equals(getKey());
        }
        return false;
    }

    public int hashCode(){
        return key == null ? 0 : key.hashCode();
    }

    public String toString(){
        return key + "=" + value;
    }
}

class Set2Map<K,V> extends HashSet<SimpleEntry>{

    public void clear(){
        super.clear();
    }

    public boolean containsKey(Object key){
        return super.contains(new SimpleEntry(key,null));
    }

    public boolean containsValue(Object value){

        for (SimpleEntry<K,V> se : this){
            if(se.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    public V get(Object key){

        for(SimpleEntry<K,V> se : this){

            if(se.getKey().equals(key)){
                return se.getValue();
            }
        }
        return null;
    }

    public void put(K key,V value){
        add(new SimpleEntry(key,value));
    }

    public void putAll(Map<? extends K,? extends V> m){

        for(K key : m.keySet()){
            add(new SimpleEntry(key,m.get(key)));
        }
    }

    public V removeEntry(Object key){

        for(Iterator iterator = this.iterator(); iterator.hasNext();){

            SimpleEntry<K,V> entry = (SimpleEntry)iterator.next();
            if(entry.getKey().equals(key)){
                V v = entry.getValue();
                iterator.remove();
                return v;
            }
        }
        return null;
    }

    public int size(){
        return super.size();
    }

}


