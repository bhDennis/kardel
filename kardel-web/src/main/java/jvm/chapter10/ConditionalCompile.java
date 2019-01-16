package jvm.chapter10;

/**
 * 条件编译 --- p.275
 *
 * 只能使用条件为常量的if语句才能达到下述效果,如使用while语句会提示 "Unreachable code"
 *
 * 对比源码 和 反编译后的代码，会发现最后只剩下一句 System.out.println("block 1");
 *
 * Created by Dennis on 2017/12/27.
 */
public class ConditionalCompile {

    public static void main(String[] args){

        if(true){
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }

//        while(false){
//            System.out.println("block 2");
//        }
    }
}
