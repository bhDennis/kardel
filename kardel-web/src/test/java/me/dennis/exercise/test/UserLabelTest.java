package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.*;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.ResolvableType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserLabelTest {

    @Test
    public void testList(){

        List<Integer> i = new ArrayList<>(3);
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);

        List<Integer> j = new ArrayList<>(2);
        j.add(3);
        j.add(4);

        i.addAll(j);
        System.out.println(i);

        Date date = new Date(1518326613000l);
        System.out.println(date);
    }

    private static final ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    public void testConcurrentHashMap(){

//        concurrentHashMap.putIfAbsent("a","b");
//        System.out.println(concurrentHashMap.putIfAbsent("a","b"));  // 如果此前没有set进去，则此处返回结果为null
        System.out.println(concurrentHashMap.put("a","b"));
    }

    @Test
    public void empty(){

        String NOT_LOCALIZABLE = "\u0000";

        System.out.println(NOT_LOCALIZABLE.equals(null));

        System.out.println(NOT_LOCALIZABLE.equals(""));

        System.out.println(NOT_LOCALIZABLE.length());

        System.out.println(NOT_LOCALIZABLE == null);
    }

    @Test
    public void other(){

        Set<String> la= new HashSet<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
            }
        };

        Set<String> lb = new HashSet<String>() {
            {
                add("e");
                add("c");
            }
        };

//        boolean result = la.retainAll(lb); //交集
//        System.out.println("交集la:"+la+",result:"+result);

        la.removeAll(lb); //差集
        System.out.println("差集lb:"+la);

        la.addAll(lb);//并集
        System.out.println("并集la:"+la);
    }

    @Test
    public void temp(){

//          System.out.println(11 | (~11));
//
//          System.out.println(2 & (~2));
//
//          System.out.println(2 & 0);
//
//          System.out.println(2 | 0);

        List<UserLabel> a = new ArrayList<UserLabel>();
        Map<String,UserLabel> b = a.stream().collect(Collectors.toMap(t->t.getId(),t->t));
        System.out.print("b:"+b.get("1"));

    }


    @Test
    public void indexOf(){       //解析URL http://www.cnblogs.com/davidwang456/p/4569283.html

//        String url = "http://www.cnblogs.com/davidwang456/p/4569283.html";
//
//        System.out.println(url.indexOf("://"));
//
//        System.out.println(url.substring(0,url.indexOf("://")));     // 协议
//
//        System.out.println(url.substring(url.indexOf("://")+3));
//
//        System.out.println(url.substring(url.indexOf("://")+3).substring(0,url.substring(url.indexOf("://")+3).indexOf("/")));    // host
//
//        System.out.println("userLabelClass:"+UserLabel.class);
//
//        System.out.println("userLabel:"+new UserLabelTest());

//        Calendar calendar = Calendar.getInstance();
//
//        System.out.println(calendar.getTime());
//
//        calendar.add(Calendar.HOUR,-20);
//
//        System.out.println(calendar.getTime());

//        List<Integer> inspectionResults = Arrays.asList(4,8);
//
//        Integer i = 4;
//        System.out.println(inspectionResults.contains(i));

//          String[] array = new String[]{};
//
//          System.out.println(array); // [Ljava.lang.String;@3e74829
//
//          String[][] array2 = new String[][]{};
//
//          System.out.println(array2); // [[Ljava.lang.String;@51e5fc98
//
//          int[] i1 = new int[]{};
//
//          System.out.println(i1);   // [I@7c469c48
//
//          Integer[] i2 = new Integer[]{};
//
//          System.out.println(i2); // [Ljava.lang.Integer;@12e61fe6
//
//          char[] c1 = new char[]{};
//
//          System.out.println(c1); // 输出空

    }

    @Test
    public void time(){       //解析URL http://www.cnblogs.com/davidwang456/p/4569283.html

        Date date = new Date();
        Calendar calendar = getCalendar(date,0,0,0,0);

        System.out.println("date:"+(calendar.getTime()));

        calendar.add(Calendar.DATE,-7);
        System.out.println("7天前date:"+(calendar.getTime()));

        calendar.add(Calendar.DATE,-8);
        System.out.println("15天前date:"+(calendar.getTime()));

        calendar.add(Calendar.DATE,-15);
        System.out.println("30天前date:"+(calendar.getTime()));

        calendar.add(Calendar.DATE,-60);
        System.out.println("60天前date:"+(calendar.getTime()));

        calendar.add(Calendar.DATE,-90);
        System.out.println("180天前date:"+(calendar.getTime()));

        Date date1 = new Date(1512642764000l);
        Calendar calendar1 = getCalendar(date1,0,0,0,0);

        System.out.println("date1:"+(calendar1.getTime()));

        System.out.println("date==date1:"+calendar1.equals(calendar));

        System.out.println("interval:"+(calendar1.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24);
    }

    private Calendar getCalendar(Date timePoint, int hour, int minute,int second ,int milliSecond) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(timePoint);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND,milliSecond);

        return calendar;
    }

    final AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void test() throws InterruptedException {

        testConcurrently();
        Thread.sleep(500);// 需要延迟如300ms会打印出自增后的值，不延迟会输出错误的值，因为test本身是一个线程，而自增是多个线程，test线程可能会早于自增中的某个线程输出，这只是假象看起来自增是错的
        System.out.println("count:"+counter.get());

    }

    @Test
    public void testConcurrently(){

        for (int i = 0; i < 264; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.incrementAndGet();
                    System.out.println("线程name:"+Thread.currentThread().getName()+"----i:"+counter.get());

                }
            }).start();
        }
    }

    @Test
    public void testOne(){

        String str = "abcx1001a";

        int firstCodePoint = str.codePointAt(2);

        int i = Character.charCount(firstCodePoint);

        int j = str.codePointAt(i);

        System.out.println("firstCodePoint:"+firstCodePoint+",i:"+i+",j:"+j);
    }

    @Test
    public void leftAndRight(){

        int number = 30;

        System.out.println("number>>>1:"+(number>>>3));

        System.out.println("number<<1:"+(number<<2));

        System.out.println("number>>1:"+(number>>3));
    }

    @Test
    public void testGenericHashSet(){

        Set<A> setA = new HashSet<>();
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        setA.add(a1);
        setA.add(a2);
        setA.add(a3);

        HashSet<C> setC = new HashSet<>();
        setC.addAll(setA);  // 说明setC只能加入其元素的子类，此时类A实现了接口C

//        Set<C> setCC = new HashSet<C>(10,0.9,true);  //HashSet中的该构造器是默认包访问级别

        System.out.println(setA.add(null));
        System.out.println(setA.contains(null));

        Set<C> setC2 = (Set<C>)setC.clone();
        System.out.println("setC:"+setC.hashCode()+",setC2:"+setC2.hashCode());
    }


    @Test
    public void testGenericHashMap(){

        Map<String,String> mapA = new HashMap<>(10);

        mapA.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("s==s2"+s == s2);
            }
        });

        mapA.replaceAll(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return null;
            }
        });

        mapA.computeIfAbsent("hzx", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return new StringBuilder(s).append("a").append("b").toString();
            }
        });

        Type[] types = mapA.getClass().getGenericInterfaces();

        Arrays.stream(types).forEach(t->{
            System.out.println(t);

        });
    }

    @Test
    public void testBytes(){
        String str = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALM47PX/YfmlKSDUmVb/t5Ud2MGr\n" +
                "0cHeXhB8uWOuJLcqU0LmtI/ZhR6y32P/Kbge32FVQEe6wO6rd8t77PpyOKQ45zOkpfxKH7rX85v6\n" +
                "Y7bme0lqkY/LbofhchaDuFenvDEmF3Q/k/mGiKtMpW1OoFnYx829rnQ+rZE3mr185e4xAgMBAAEC\n" +
                "gYA5qoRcNrrwl5rfLGjWXFtWiI746e8JASKlDWydTSgVI3I84XyRmHzDvuwwAacLzisz5zlSmx1+\n" +
                "7f8SoyJCB0R/z1Vr9F8we1hfEtkqjuvpKbUNZbHrPDaG1AAfjZFsH1Fh/hQ5Cs6E5NSCdzNMr+v/\n" +
                "oFA9nVnXvLlnzQntMa3hHQJBAPgkCkB6Y32jlU0jIfP2K6//jwZ9m5sRg31JGUA+uMV/UGM2ksr8\n" +
                "Z1IIImWSq47eeduaklqN7R6y/1+PPqKLfM8CQQC45hXicEaRG+49tYt4MBbUXR8VrD27h3VvKOKu\n" +
                "Kc1+OIpH9/hHU6BLrDxf29kg27oVYsVjvZvK8n13oYJIAKT/AkByKOqKhYQWPlcm+N3bBktNGk7r\n" +
                "1ofrTKBo2GOEmhaZzhvmuSnJt1u1csaYYmUJQrNfY/qnLJqFwCYbCaTwVSojAkAkJ6GZ4Jh74XlJ\n" +
                "iclW3BhquDbO1xpPJCK7dMQ2iCgNiWLIxd0/nUOX6Hr5x5SCj1Sov+KXKUlgeuA711IRYEbjAkEA\n" +
                "iRYDamSh72gSsKDASF5FzBGX6YyExLJHs6Mv78t3y3EsPSGRDpqOAL/mdpIpM9WWe0V1Kitpy+yC\n" +
                "9gflKE2e+A==";
        System.out.println(str.getBytes().length);
    }


    public HashMap<Integer,List<String>> myMap;

    @Test
    public void testResolvableType() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        ResolvableType resolvableType = ResolvableType.forField(getClass().getField("myMap"));
        System.out.println("superType:"+resolvableType.getSuperType());
        System.out.println("asMap:"+resolvableType.asMap());
        System.out.println("generic0:"+resolvableType.getGeneric(0).resolve());
        System.out.println("generic1:"+resolvableType.getGeneric(1).resolve());
        System.out.println("generic11:"+resolvableType.getGeneric(1));
        System.out.println("generic12:"+resolvableType.resolveGeneric(1,0));


        resolvableType = ResolvableType.forClass(TestApplicationContextInitializer.class);
        System.out.println("resolvableType:"+resolvableType);

        resolvableType = resolvableType.as(ApplicationContextInitializer.class);  // 获取其基类（即其实现的接口或者抽象类）
        System.out.println("resolvableType:"+resolvableType);
        System.out.println("resolvableType:"+resolvableType.getGeneric().resolve());
        System.out.println("isInstance:"+resolvableType.getGeneric().isInstance(new XmlWebApplicationContext()));

    }

    @Test
    public void testBit(){

//        Integer documentFlags = 0;
//        System.out.println(documentFlags | 32);
//
//        if(1==1){
//            System.out.println("testBit1");
//        }else if(1<2){
//            System.out.println("testBit2");
//        }

        for(int i=0;i<10;i++){

            if(i>5){
              return;
            }
            System.out.println(i);
        }
    }

    @Test
    public void testStream(){

        List<Integer> a = Arrays.asList(1,2,3,4,5);

        a = a.stream().filter(c-> c!=5).collect(Collectors.toList());

        System.out.println("a"+a);

//        System.out.println("b"+b);
    }

    @Test
    public void testLinkedHashMap(){

        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach( (k,v) -> {
            System.out.println(k +":" + v);
        });
        // 模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach( (k,v) -> {
            System.out.println(k +":" + v);
        });
        // 触发删除
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach( (k,v) -> {// 遍历顺序不变
            System.out.println(k +":" + v);
        });
    }

    @Test
    public void testObjectEquals(){

        A a = new A();
        A a1 = new A();

        System.out.println(a.equals(a1));
    }

    @Test
    public void testToSet(){

//        List<User> s = new ArrayList<>();
//
//        User user = new User("张三",1);
//        User user1 = new User("张三1",1);
//        User user2 = new User("张三2",2);
//        User user3 = new User("张三3",3);
//        User user4 = new User("张三4",3);
//        s.add(user);
//        s.add(user1);
//        s.add(user2);
//        s.add(user3);
//        s.add(user4);
//
//        System.out.println(s);
//
//        Set<Integer> ages = s.stream().map(a->a.getAge()).collect(Collectors.toSet());
//        System.out.println(ages);

          System.out.println("1".equals(""));
          System.out.println(null instanceof String);
    }
}
