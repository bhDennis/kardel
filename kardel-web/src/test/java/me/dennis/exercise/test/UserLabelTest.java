package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import org.junit.Before;
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
    public void handleData(){

        List<String> allDatas = Arrays.asList
                ("SHTB000001", "SHTB000003", "SHTB000004", "SHTB000006", "SHTB000011", "SHTB000017", "SHTB000019", "SHTB000020", "SHTB000021", "SHTB000022", "SHTB000024", "SHTB000025", "SHTB000026", "SHTB000031", "SHTB000033", "SHTB000035", "SHTB000036", "SHTB000049", "SHTB000050", "SHTB000051", "SHTB000052", "SHTB000054", "SHTB000057", "SHTB000058", "SHTB000066", "SHTB000070", "SHTB000075", "SHTB000079", "SHTB000081", "SHTB000082", "SHTB000083", "SHTB000089", "SHTB000093", "SHTB000096", "SHTB000097", "SHTB000098", "SHYC000016", "SHYC000044", "SHSH000001", "SHSH000002", "SHXX000010", "SHXX000014", "SHXX000017", "SHXX000020", "SHLH010012", "SHLH010058", "SHLH060014", "SHLH060019", "SHLH060042", "SHXX000027", "SHXX000031", "SHXX000034", "SHSH000003", "SHSH000004", "SHSH000005", "SHSH000006", "SHSH000007", "SHSH000008", "SHSH000009", "SHSH000010", "SHCJ010002", "SHSH000012", "SHSH000013", "SHSH000014", "SHSH000011", "SHXX000041", "SHXX000049", "SHLH101001", "SHLH101002", "SHLH101003", "SHLH101006", "SHLH101007", "SHLH102002", "SHLH103002", "SHLH103007", "SHLH201002", "SHLH201003", "SHLH202005", "SHLH202008", "SHLH203004", "SHLH301002", "SHLH301004", "SHLH402005", "SHLH403007", "SHCK100002", "SHSH000016", "SHSH000017", "SHSH000018", "SHSH000019", "SHSH000020", "SHSH000022", "SHTB000160", "SHTB000163", "SHTB000195", "SHTB000196", "SHTB000198", "SHTB000199", "SHCK100003", "SHCK100004", "SHTB000241", "SHTB000242", "SHTB000244", "SHTB000245", "SHTB000250", "SHTB000249", "SHTB000248", "SHTB000246", "SHTB000239", "SHTB000238", "SHTB000237", "SHTB000236", "SHTB000230", "SHTB000229", "SHTB000226", "SHTB000223", "SHTB000222", "SHTB000220", "SHTB000219", "SHTB000218", "SHTB000217", "SHTB000215", "SHTB000214", "SHTB000213", "SHTB000211", "SHTB000210", "SHTB000208", "SHTB000207", "SHTB000203", "SHTB000204", "SHCK100006", "SHXX000090","zhanglj14", "zhanglj11", "SHZJ00001", "SHTB00502", "SHTB00503", "SHTB00505", "SHTB00605", "SHTDJC065", "SHTB00606", "zhutaotest_app");
        List<String> lessDatas = Arrays.asList
                ("SHCK100002", "SHCK100003", "SHCK100004", "SHLH010012", "SHLH010058", "SHLH060014", "SHLH060019", "SHLH060042", "SHLH101001", "SHLH101002", "SHLH101003", "SHLH101006", "SHLH101007", "SHLH102002", "SHLH103002", "SHLH103007", "SHLH201002", "SHLH202005", "SHLH203004", "SHLH301002", "SHLH301004", "SHLH402005", "SHLH403007", "SHSH000002", "SHSH000003", "SHSH000006", "SHSH000007", "SHSH000008", "SHSH000009", "SHSH000010", "SHSH000011", "SHSH000012", "SHSH000014", "SHSH000016", "SHSH000017", "SHSH000019", "SHSH000020", "SHSH000022", "SHTB000001", "SHTB000003", "SHTB000004", "SHTB000006", "SHTB000011", "SHTB000017", "SHTB000019", "SHTB000020", "SHTB000021", "SHTB000024", "SHTB000025", "SHTB000026", "SHTB000033", "SHTB000035", "SHTB000036", "SHTB000050", "SHTB000051", "SHTB000054", "SHTB000057", "SHTB000058", "SHTB000066", "SHTB000079", "SHTB000081", "SHTB000082", "SHTB000083", "SHTB000089", "SHTB000093", "SHTB000096", "SHTB000097", "SHTB000098", "SHTB000163", "SHTB000195", "SHTB000196", "SHTB000199", "SHTB000203", "SHTB000204", "SHTB000207", "SHTB000208", "SHTB000211", "SHTB000213", "SHTB000214", "SHTB000215", "SHTB000217", "SHTB000218", "SHTB000219", "SHTB000220", "SHTB000222", "SHTB000223", "SHTB000226", "SHTB000229", "SHTB000230", "SHTB000236", "SHTB000237", "SHTB000238", "SHTB000239", "SHTB000241", "SHTB000242", "SHTB000244", "SHTB000245", "SHTB000246", "SHTB000248", "SHTB000249", "SHTB000250", "SHXX000010", "SHXX000014", "SHXX000017", "SHXX000020", "SHXX000027", "SHXX000031", "SHXX000034", "SHXX000041", "SHXX000049", "SHXX000090", "SHYC000016", "SHYC000044","SHTB00502", "SHTB00503", "SHTB00505", "SHTB00606", "SHTDJC065", "SHZJ00001", "zhanglj11", "zhanglj14", "zhutaotest_app");
        System.out.println("lessDatas:"+lessDatas.size()+",allDatas:"+allDatas.size());
        for(String s : allDatas){

            if(!lessDatas.contains(s)){
                System.out.println(s);
            }
        }
    }

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
}
