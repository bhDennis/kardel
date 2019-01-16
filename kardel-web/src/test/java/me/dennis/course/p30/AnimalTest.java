package me.dennis.course.p30;

/**
 * 执行顺序：父类的非静态初始块、构造器 ---->当前类的非静态初始化块、构造器
 * Created by Dennis on 2018/8/13.
 */
public class AnimalTest {

    public static void main(String[] args){
        new Wolf(5.6);
    }
}

class Creature{

    {
        System.out.println("Creature 非静态初始化块");
    }

    public Creature(){
        System.out.println("Creature 无参构造器");
    }

    public Creature(String name){
        this();
        System.out.println("Creature 带有name参数构造器,name=["+name+"]");
    }
}

class Animal extends Creature{

    {
        System.out.println("Animal 非静态初始化块");
    }

    public Animal(String name){
        super(name);
        System.out.println("Animal带一个参数的构造器，name参数:"+name);
    }
    public Animal(String name,int age){
        this(name);
        System.out.println("Animal带两个参数的构造器，name参数:"+name+",age参数:"+age);
    }
}

class Wolf extends Animal{

    {
        System.out.println("WolfTest 非静态初始化块");
    }

    public Wolf(){
        super("灰太狼",3);
        System.out.println("Wolf无参构造器");
    }
    public Wolf(double weight){
        this();
        System.out.println("Wolf带有weight参数的构造器,weight参数:"+weight);
    }
}
