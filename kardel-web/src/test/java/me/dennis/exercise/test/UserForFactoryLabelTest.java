package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import me.dennis.generic.ClassB;
import me.dennis.generic.ClassBB;
import me.dennis.generic.InterfaceA;
import me.dennis.generic.InterfaceB;
import mode.creational.design.factory.abstrac.chapter15.model.UserForFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.ref.*;
import java.lang.reflect.Field;
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
public class UserForFactoryLabelTest {

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

        List<UserLabel> a = new ArrayList<>();
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
//        System.out.println("userLabel:"+new UserForFactoryLabelTest());

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
    public void testChar(){

        char s = 'a';
        System.out.println(s);
        System.out.println((int)s);
        System.out.println(Integer.parseInt("10"));
    }

    @Test
    public void testMap(){

        Hashtable hashtable = new Hashtable();
        hashtable.put("a","a");

        HashMap hashMap = new HashMap();
        hashMap.put(null,"a");
        hashMap.put("a",null);
        hashMap.put("b",null);
        hashMap.put(null,null);

        System.out.println(hashMap);

        TreeMap treeMap = new TreeMap();
        treeMap.put("a",null);
    }

    class Util {
        public final Integer info = 123;
    }

    @Test
    public void testFinal() throws NoSuchFieldException, IllegalAccessException {
        Util util = new Util();
        Field field = util.getClass().getDeclaredField("info");
        //如果将Util中的info定义为int，则无法通过反射修改值，这是因为定义为基本数据类型，会被当作constant
        field.setAccessible(true);
        field.set(util,789);
        System.out.println(field.get(util));
        System.out.println(util.info);
    }

    /**
     * 这时候sf是对obj的一个软引用，通过sf.get()方法可以取到这个对象，
     * 当然，当这个对象被标记为需要回收的对象时，则返回null；
     * 软引用主要用户实现类似缓存的功能，在内存足够的情况下直接通过软引用取值，
     * 无需从繁忙的真实来源查询数据，提升速度；当内存不足时，自动删除这部分缓存数据，从真正的来源查询这些数据。
     */
    @Test
    public void testSoftReference(){

        Object obj = new Object();
        System.out.println(obj);
        SoftReference<Object> sf = new SoftReference<Object>(obj);
        obj = null;
        System.out.println("sf:"+sf.get()+",obj:"+obj);//有时候会返回null
    }

    /**
     * 弱引用是在第二次垃圾回收时回收，短时间内通过弱引用取对应的数据，
     * 可以取到，当执行过第二次垃圾回收时，将返回null。
     * 弱引用主要用于监控对象是否已经被垃圾回收器标记为即将回收的垃圾，
     * 可以通过弱引用的isEnQueued方法返回对象是否被垃圾回收器标记。
     */
    @Test
    public void testWeakReference(){

        Object obj = new Object();
        System.out.println(obj);
        WeakReference<Object> wf = new WeakReference<Object>(obj);
        obj = null;
        System.out.println("sf:"+wf.get()+",obj:"+obj);//有时候会返回null
    }

    /**
     * 虚引用是每次垃圾回收的时候都会被回收，
     * 通过虚引用的get方法永远获取到的数据为null，因此也被成为幽灵引用。
     * 虚引用主要用于检测对象是否已经从内存中删除。
     */
    @Test
    public void testPhantomReference(){

        Object obj = new Object();
        PhantomReference<Object> pf = new PhantomReference<Object>(obj,new ReferenceQueue());
        obj=null;
        System.out.println("sf:"+pf.get()+",obj:"+obj);//总是返回null
    }

    public static boolean isRun = true;

    @Test
    public void testPhantomReference2() throws InterruptedException {

        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());
        final ReferenceQueue referenceQueue = new ReferenceQueue<String>();
        new Thread() {
            public void run() {
                while (isRun) {
                    Object o = referenceQueue.poll();
                    if (o != null) {
                        try {
                            Field referent = Reference.class.getDeclaredField("referent");
                            referent.setAccessible(true);
                            Object result = referent.get(o);
                            System.out.println("gc will collect:" + result.getClass() + "@" + result.hashCode());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc, referenceQueue);
        abc = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        isRun = false;
    }

    @Test
    public void testWJBK() throws InterruptedException {

        WeakReference r = new WeakReference(new String("I’m here"));

        WeakReference sr = new WeakReference("I’m here");//sr 直接引用的常量池中的字面量 "I’m here"，而常量池对这个字面量本身也有引用，所以无法回收

        System.gc();
        Thread.sleep(1000);

        // only r.get() becomes null
        System.out.println("after gc:r =" + r.get() + ",static=" + sr.get());
    }

    /**
     * 枚举类转成json时调用的是Enum.name()方法，而不是其code、value值
     */
    @Test
    public void testGetInformationType() {

        EnumProductInformationType result = EnumProductInformationType.getByFlow(1);
//        System.out.print(JSON.toJSON(result));
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
    public void testToSet(){

//        List<UserForFactory> s = new ArrayList<>();
//
//        UserForFactory user = new UserForFactory("张三",1);
//        UserForFactory user1 = new UserForFactory("张三1",1);
//        UserForFactory user2 = new UserForFactory("张三2",2);
//        UserForFactory user3 = new UserForFactory("张三3",3);
//        UserForFactory user4 = new UserForFactory("张三4",3);
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
    public void testSystemArrayCopy(){

        UserForFactory userForFactory = new UserForFactory("zhangsan",11,"1");
        UserForFactory userForFactory1 = new UserForFactory("lisi",22,"2");
        UserForFactory[] userForFactories = new UserForFactory[]{userForFactory, userForFactory1};
        System.out.println(userForFactories[0].hashCode());
    }

    @Test
    public void testListToSet(){

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(1);
        integers.add(4);

        Set<Integer> integers1  = new HashSet<>();
        integers1.addAll(integers);

        System.out.println("integers:"+integers+","+integers.size());
        System.out.println("integers1:"+integers1+","+integers1.size());
    }


    @Test
    public void testEquals(){
        Integer i=null;
        String a = "a";
        System.out.println(a.equals(i));
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

        List<UserForFactory> userForFactories = new ArrayList<>();
        UserForFactory userForFactory = UserForFactory.builder()
                .productNo("20181126085821542217")
                .name("hzx")
                .build();
        userForFactories.add(userForFactory);

        userForFactory =  UserForFactory.builder()
                .productNo("20181126085821542217")
                .name("hxl")
                .build();
        userForFactories.add(userForFactory);

        userForFactory =  UserForFactory.builder()
                .productNo("20181126085821542218")
                .name("hxl")
                .build();
        userForFactories.add(userForFactory);

        Map<String,List<UserForFactory>> mapGroupByProductNo = userForFactories.stream().collect(Collectors.groupingBy(a->a.getProductNo()));
        List<UserForFactory> empUserForFactories;
        for(String productNo: mapGroupByProductNo.keySet()){
            empUserForFactories =  mapGroupByProductNo.get(productNo);
            if(empUserForFactories.size() >1){
                System.out.println("productNo:"+productNo);
            }
        }
    }

    @Test
    public void testAtomicInteger(){

        AtomicInteger atomicInteger = new AtomicInteger(2);

        System.out.println(atomicInteger.incrementAndGet());
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
