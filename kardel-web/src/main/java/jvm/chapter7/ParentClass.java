package jvm.chapter7;

/**
 * 继承ParentInterface接口是为了证明存在同名变量时是否会报错
 *
 * 结果：不会报错
 *
 * Created by dennis on 2019/1/20.
 */
public class ParentClass implements ParentInterface{

    public static int pa = 1;

    public int pb = 1;

    public static final int fc = 2;

    public static final int fct = 2;


    static {
        System.out.println("-- static ParentClass --");
    }

    {
        System.out.println("-- block ParentClass --");
    }

    public ParentClass(){
        System.out.println("-- parent class --");
    }

    public void methodParentA(){
        System.out.println("-- parent methodA --");
    }

    public void methodB(){
        System.out.println("-- parent methodB --");
    }
}
