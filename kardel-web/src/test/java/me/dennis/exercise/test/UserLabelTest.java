package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import me.dennis.generic.ClassB;
import me.dennis.generic.ClassBB;
import me.dennis.generic.InterfaceA;
import me.dennis.generic.InterfaceB;
import mode.creational.design.factory.abstrac.chapter15.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.*;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.GenericTypeResolver;
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

    @Test
    public void testLoopFinal(){

        List<String> agentNos = Arrays.asList("A","B","C","D");
        for(String agentNo : agentNos){
            final String a = agentNo+"hzx";
            System.out.println(a);
        }
    }

    @Test
    public void testXOR(){

        Integer isXOR1 = 1^4864;
        Integer isXOR2 = 2^4864;
        Integer isXOR3 = 4^4864;
        Integer isXOR4 = 8^4864;
        Integer isXOR5 = 16^4864;
        Integer isXOR6 = 32^4864;
        Integer isXOR7 = 64^4864;
        Integer isXOR8 = 128^4864;
        Integer isXOR9 = 256^4864;
        Integer isXOR10 = 512^4864;
        Integer isXOR11 = 1024^4864;
        Integer isXOR12 = 2048^4864;
        Integer isXOR13 = 4096^4864;

        System.out.println("isXOR1="+isXOR1);
        System.out.println("isXOR2="+isXOR2);
        System.out.println("isXOR3="+isXOR3);
        System.out.println("isXOR4="+isXOR4);
        System.out.println("isXOR5="+isXOR5);
        System.out.println("isXOR6="+isXOR6);
        System.out.println("isXOR7="+isXOR7);
        System.out.println("isXOR8="+isXOR8);
        System.out.println("isXOR9="+isXOR9);
        System.out.println("isXOR10="+isXOR10);
        System.out.println("isXOR11="+isXOR11);
        System.out.println("isXOR12="+isXOR12);
        System.out.println("isXOR13="+isXOR13);

        System.out.println("isXOR14="+(256|512|4096));
    }

    @Test
    public void testListI(){

        List<String> minProductNos = Arrays.asList("20180910194631495473", "20180921165024084514", "20180921185321361085", "20180922150148289470", "20180922163750118700", "20180922182103436245", "20180923081638330423", "20180923095523029621", "20180923110335131395", "20180923142721060473", "20180923151611320807", "20180923155547285569", "20180923174336710992", "20180923174336738505", "20180923200821227105", "20180923204725165936", "20180923230555458996", "20180924002057359409", "20180924094336177249", "20180924101209510970", "20180924101209535199", "20180924101209645029", "20180924101209814770", "20180924101209860845", "20180924101850530590", "20180924101850561314", "20180924101850643411", "20180924101850795253", "20180924102958556697", "20180924102958607663", "20180924102958608241", "20180924102958684353", "20180924102958833793", "20180924102958856509", "20180924102958870764", "20180924103519566268", "20180924103519578470", "20180924103519588581", "20180924103519603548", "20180924103519630222", "20180924103519667978", "20180924103519718098", "20180924103519761883", "20180924103519767892", "20180924103519829997", "20180924103519875804", "20180924105231454516", "20180924110233199450", "20180924130521531623", "20180924130521545913", "20180924130521773174", "20180924130521774782", "20180924130521774821", "20180924131001505412", "20180924131001523029", "20180924131001535885", "20180924131001553462", "20180924131001634856", "20180924131001649713", "20180924131001680271", "20180924131001722148", "20180924131001722754", "20180924131001738796", "20180924131001739975", "20180924131001756221", "20180924131001770242", "20180924131001780066", "20180924131001814606", "20180924131001832436", "20180924131001856192", "20180924131001885586", "20180924131001899936", "20180924131517548442", "20180924131517587615", "20180924131517589389", "20180924131517602268", "20180924131517628077", "20180924131517665759", "20180924131517681894", "20180924131517685076", "20180924131517709823", "20180924131517710264", "20180924131517770308", "20180924131517839493", "20180924131517874096", "20180924131517876082", "20180924131517885879", "20180924131517889504", "20180924131517893840", "20180924132010758332", "20180924132010890874", "20180924135440228459", "20180924140734323795", "20180924142743501715", "20180924142743638814", "20180924142743668387", "20180924142743691653", "20180924142743742556", "20180924142743895806", "20180924160854247476", "20180924172535385163", "20180924174520139460", "20180924180524366648", "20180924182535246733", "20180924192718180428", "20180924195858173326", "20180924201230361356", "20180924234525410253", "20180925001920292109", "20180925085422074709", "20180925092433473222", "20180925101604017594", "20180925110002090054", "20180925121543231274", "20180925155946211053", "20180925190524003986", "20180926003649233770", "20180926103948076808", "20180927175042626218", "20180927175042769329", "20180927175619683397", "20180927175619883703", "20180927175810556083", "20180927180121661031", "20180927180626516721", "20180927180626573371", "20180927181111545578", "20180927181111556686", "20180927181111736579", "20180927181111737641", "20180927181111741108", "20180927181111768408", "20180927181111776071", "20180927181111796538", "20180927181111802869", "20180927181111808128", "20180927181111814080", "20180927181111862188", "20180927181111868734", "20180927181111899810", "20180927181547525694", "20180927181547559618", "20180927181547643478", "20180927181547728268", "20180927181547728394", "20180927181547761705", "20180928105546508496", "20180928105546594702", "20180928105546599630", "20180928105546671594", "20180928105546809092", "20180928105932520845", "20180928105932560190",
                "20180928105932679563", "20180928105932712275", "20180928105932742401", "20180928105932866173");

        List<String> allProductNos = Arrays.asList("20180910194631495473", "20180921165024084514", "20180921185321361085",
                "20180922150148289470", "20180922163750118700", "20180922182103436245", "20180923081638330423", "20180923095523029621", "20180923110335131395", "20180923142721060473", "20180923151611320807", "20180923155547285569", "20180923174336710992", "20180923174336738505", "20180923200821227105", "20180923204725165936", "20180923230555458996", "20180924002057359409", "20180924094336177249", "20180924101209510970", "20180924101209535199", "20180924101209645029", "20180924101209814770", "20180924101209860845", "20180924101850530590", "20180924101850561314", "20180924101850643411", "20180924101850795253", "20180924102958556697", "20180924102958607663", "20180924102958608241", "20180924102958684353", "20180924102958833793", "20180924102958856509", "20180924102958870764", "20180924103519566268", "20180924103519578470", "20180924103519588581", "20180924103519603548", "20180924103519630222", "20180924103519667978", "20180924103519718098", "20180924103519761883", "20180924103519767892", "20180924103519829997", "20180924103519875804", "20180924105231454516", "20180924110233199450", "20180924130521531623", "20180924130521545913", "20180924130521773174", "20180924130521774782", "20180924130521774821", "20180924131001505412", "20180924131001523029", "20180924131001535885", "20180924131001553462", "20180924131001634856", "20180924131001649713", "20180924131001680271", "20180924131001722148", "20180924131001722754", "20180924131001738796", "20180924131001739975", "20180924131001756221", "20180924131001770242", "20180924131001780066", "20180924131001814606", "20180924131001832436", "20180924131001856192", "20180924131001885586", "20180924131001899936", "20180924131517548442", "20180924131517587615", "20180924131517589389", "20180924131517602268", "20180924131517628077", "20180924131517665759", "20180924131517681894", "20180924131517685076", "20180924131517709823", "20180924131517710264", "20180924131517770308", "20180924131517839493", "20180924131517874096", "20180924131517876082", "20180924131517885879", "20180924131517889504", "20180924131517893840", "20180924132010758332", "20180924132010890874", "20180924135440228459", "20180924140734323795", "20180924142743501715", "20180924142743638814", "20180924142743668387", "20180924142743691653", "20180924142743742556", "20180924142743895806", "20180924160854247476", "20180924172535385163", "20180924174520139460", "20180924180524366648", "20180924182535246733", "20180924192718180428", "20180924195858173326", "20180924201230361356", "20180924234525410253", "20180925001920292109", "20180925085422074709", "20180925092433473222", "20180925101604017594", "20180925110002090054", "20180925121543231274", "20180925155946211053", "20180925190524003986", "20180926003649233770", "20180926103948076808", "20180927175042626218", "20180927175042769329", "20180927175619683397", "20180927175619883703", "20180927175810556083", "20180927180121661031", "20180927180626516721", "20180927180626573371", "20180927181111503260", "20180927181111545578", "20180927181111556686", "20180927181111736579", "20180927181111737641", "20180927181111741108", "20180927181111768408", "20180927181111776071", "20180927181111796538", "20180927181111802869", "20180927181111808128", "20180927181111814080", "20180927181111862188", "20180927181111868734", "20180927181111899810", "20180927181547525694", "20180927181547559618", "20180927181547643478", "20180927181547728268", "20180927181547728394", "20180927181547761705", "20180928105546508496", "20180928105546594702", "20180928105546599630", "20180928105546671594", "20180928105546809092", "20180928105932520845", "20180928105932560190", "20180928105932679563", "20180928105932712275", "20180928105932742401", "20180928105932866173");

       for(String productNo : allProductNos){

           if(!minProductNos.contains(productNo)){

               System.out.println(productNo);
           }
       }
    }

    @Test
    public void testSystemArrayCopy(){

        User user = new User("zhangsan",11,"1");
        User user1 = new User("lisi",22,"2");
        User[] users = new User[]{user,user1};
        System.out.println(users[0].hashCode());
    }

    @Test
    public void testListToSet(){

        List<Integer> integers = new ArrayList<>();
        integers.add(9); // index = 0;
        integers.add(2);
        integers.add(1);
        integers.add(4); // index = 3;

        integers.removeIf(a->{

            if(a.equals(9)){
                return true;
            }
            return false;
        });
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        Set<Integer> integers1  = new HashSet<>();
        integers1.addAll(integers);


        System.out.println("integers:"+integers+","+integers.size());
        System.out.println("integers1:"+integers1+","+integers1.size());
    }

    @Test
    public void testSystemCurrentTime(){
        System.out.println("1541148164486");
        Date date = new Date(1541148164486l);
        System.out.println(date);
    }

    int p;
    @Test
    public void testEquals(){
        Integer i=null;
        String a = "a";
        System.out.println(a.equals(i));
        System.out.println(p);
    }

    @Test
    public void testA(){
        int i = (1320000/10000) & (1280000/10000);
        System.out.println();
    }

    @Test
    public void testGeneric(){
        Class<?> argumentClass = GenericTypeResolver.resolveTypeArgument(ClassB.class, InterfaceB.class);
        System.out.println(argumentClass); // 解析ClassB里的泛型参数
        System.out.println("父类 --> 子类:"+InterfaceA.class.isAssignableFrom(argumentClass)); //
        System.out.println("父类 --> 子类："+ClassB.class.isInstance(new ClassBB()));
        System.out.println("子类 --> 父类："+ClassBB.class.isInstance(new ClassB()));
    }

    @Test
    public void testGroupBy(){

        List<User> users = new ArrayList<>();
        User user = User.builder()
                .productNo("20181126085821542217")
                .name("hzx")
                .build();
        users.add(user);

        user =  User.builder()
                .productNo("20181126085821542217")
                .name("hxl")
                .build();
        users.add(user);

        user =  User.builder()
                .productNo("20181126085821542218")
                .name("hxl")
                .build();
        users.add(user);

        Map<String,List<User>> mapGroupByProductNo = users.stream().collect(Collectors.groupingBy(a->a.getProductNo()));
        List<User> empUsers = null;
        for(String productNo: mapGroupByProductNo.keySet()){
            empUsers =  mapGroupByProductNo.get(productNo);
            if(empUsers.size() >1){
                System.out.println("productNo:"+productNo);
            }
        }
    }

    @Test
    public void testRetain(){

        List<Integer> listA = new ArrayList<Integer>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);
        listA.add(6);

        List<Integer> listB = new ArrayList<Integer>();

        listB.add(3);
        listB.add(4);
        listB.add(6);
        listB.add(9);

        listB.retainAll(listA);
        System.out.println(listB);

    }
}
