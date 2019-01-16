package me.dennis.course.p37;

/**
 * Created by Dennis on 2018/8/16.
 */
public class FieldAndMethodTest {

    public static void main(String[] args){

        Base base = new Base();
        System.out.println(base.count); //2
        base.display();//2

        Derived derived = new Derived();
        System.out.println(derived.count);//20
        derived.display();//20

        Base base1 = new Derived();
        System.out.println(base1.count);//2
        base1.display();//20

        Base base2 = derived;
        System.out.println(base2.count);//2
    }
}
class Base{

    int count = 2;

    public void display(){
        System.out.println(this.count);
    }
}
class Derived extends Base{

    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}
