package me.dennis.course.p39;

/**
 * Created by Dennis on 2018/8/20.
 */
public class SubTest extends Mid{

    int count = 200;
    public static void main(String[] args){

        SubTest subTest = new SubTest();
        Mid mid = subTest;
        Base base = subTest;

        System.out.println(subTest.count);//200
        System.out.println(mid.count);//20
        System.out.println(base.count);//2
        subTest.accessMid();
    }

    public void accessMid(){
        System.out.println(super.count);
    }
}


class Base{
    int count = 2;
}

class Mid extends Base{
    int count = 20;
}
