package jvm.chapter7;

/**
 * 自定义测试：测试子类是否可以访问父类的实例方法(methodParentA)，以及实例变量(pb)
 * 结果：可以访问
 *
 * Created by dennis on 2019/1/20.
 */
public class InstanceTest {

    public static void main(String[] args){

          System.out.println(ChildClass.fc);

//          ParentInterface.interfaceMethod();

//        ChildClass childClass = new ChildClass();
//        childClass.methodParentA();
//        childClass.methodB();
//        System.out.println(childClass.pb);
//        childClass.pb = 10;  //子类可以访问父类的成员变量，并且允许修改，破坏了'封装性'
//        System.out.println(childClass.pb);
    }
}
