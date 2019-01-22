package jvm.chapter7;

/**
 * Created by dennis on 2019/1/20.
 */
public class ChildClass extends ParentClass{

    public static int ca = 1;

    public int cb = 1;

//    public static int fc = 3;

    static {
        System.out.println("-- static ChildClass --");
    }

    {
        System.out.println("-- block ChildClass --");
    }

    public ChildClass(){
        System.out.println("-- child class --");
    }

    public void methodChildA(){
        System.out.println("-- child methodA --");
    }

    public void methodB(){
        System.out.println("-- child methodB --");
    }
}
