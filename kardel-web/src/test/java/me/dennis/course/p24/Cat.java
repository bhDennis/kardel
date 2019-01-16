package me.dennis.course.p24;

/**
 * Created by Dennis on 2018/8/8.
 */
public class Cat {

    String name;
    int age;
    public Cat(String name,int age){
        System.out.println("执行构造器");
        this.name = name;
        this.age = age;
    }
    {
        System.out.println("执行非静态初始块");
        weight = 2.0;
    }
    double weight = 2.3;
    public String toString(){
        return "Cat[name="+ name+",age="+age+",weight="+weight+"]";
    }
}
