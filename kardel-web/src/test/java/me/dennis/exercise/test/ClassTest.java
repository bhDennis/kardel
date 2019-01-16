package me.dennis.exercise.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * 参考链接：https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html
 *
 * Created by Dennis on 2018/5/18.
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        // 对象实例.getClass()语法形式
        Class strClass = "foo".getClass();
        System.out.println("foo.class---->"+ strClass);

        Class enumClass = E.EA.getClass();
        System.out.println("enumClass.class---->"+enumClass);

        byte[] bytes = new byte[1024];
        Class bytesClass = bytes.getClass();
        System.out.println("bytesClass.class---->"+bytesClass);

        Set<String> strSet = new HashSet<>();
        Class setClass = strSet.getClass();
        System.out.println("setClass.class---->"+setClass);


        // .class语法形式
        Class noInstanceClass = boolean.class;  // correct
        System.out.println("noInstanceClass.class---->"+noInstanceClass);


        // Class.forName()语法形式 不能被用于基本类型
        Class aClass = Class.forName("me.dennis.exercise.test.A");
        System.out.println("aClass.class---->"+aClass);

        Class doubleArrayClass = Class.forName("[D");
        System.out.println("doubleArrayClass.class---->"+doubleArrayClass);

        Class stringArrayClass = Class.forName("[[Ljava.lang.String;");  //String二维数组
        System.out.println("stringArrayClass.class---->"+stringArrayClass);

        // 从包装类获取基础类型的class对象
        Class doubleClassExt = Double.TYPE;
        System.out.println("doubleClassExt.class---->"+doubleClassExt);


        // 返回某个类的超类
        Class JButtonClass = javax.swing.JButton.class.getSuperclass();
        System.out.println("JButtonClass.class---->"+JButtonClass);

        // 返回类中的public成员类
        Class<?>[] classes = Character.class.getClasses();
        List<Class> classList = new ArrayList<>(classes.length);
        for(Class a : classes){
            classList.add(a);
        }
        System.out.println("classes.class---->"+classList);

        // 返回类中的所有声明类
        Class<?>[] declaredClasses = Character.class.getDeclaredClasses();
        List<Class> declaredClassesList = new ArrayList<>(declaredClasses.length);
        for(Class a : declaredClasses){
            declaredClassesList.add(a);
        }
        System.out.println("declaredClasses.class---->"+declaredClassesList);

        // 返回声明了某个字段的所在类的class对象
        Field field = System.class.getField("out");
        Class fieldDeclaringClass = field.getDeclaringClass();
        System.out.println("fieldDeclaringClass.class---->"+fieldDeclaringClass);

        // 返回该类的直接封闭类
        Class stateEnclosingClass = Thread.State.class.getEnclosingClass();
        System.out.println("stateEnclosingClass.class---->"+stateEnclosingClass);
    }
}

