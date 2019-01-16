package me.dennis.course.p32;

/**
 * Created by Dennis on 2018/8/13.
 */
public class BaseTest {

    public static void main(String[] args){
        new Derived();
    }
}

class Base{

    private int i = 2;  //编译时 i=2赋值这一操作会被放入构造器中，因此程序先将Base类中的i赋值为2，再调用this.display()方法
    public Base(){ //this在构造器中时，代表正在初始化的Java对象，此处this虽然位于Base构造器中，但是这些代码实际放在Derived中，因此此处this代表Derived对象
        System.out.println("当前this引用:"+this.getClass()+",i="+this.i);//this.i输出为2，是因为this虽然代表Derived对象，但是它却位于Base构造器中，它的编译时类型是Base，但实际引用了一个Derived对象

        /**
         * 当变量的编译类型和运行时类型不同时，通过该变量访问它引用的对象的实例变量时，
         * 该实例变量的值由声明该变量的类型来决定。但通过该变量调用它引用的对象的实例方法时，该方法行为将由它实际所引用的对象来决定。
         * 因此thi.i访问的是Base中定义的i,而this.display()则表现的是Derived对象的行为。
         */
        this.display();
    }
    public void display() {
        System.out.println(i);
    }
}

class Derived extends Base{

    private int i = 22;

    public Derived(){
        i = 222;
    }

    public void display() {
        System.out.println(i);
    }
}