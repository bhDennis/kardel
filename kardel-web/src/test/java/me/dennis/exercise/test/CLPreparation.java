package me.dennis.exercise.test;

/**
 * 执行 javap -v CLPreparation.class
 * 查看会发现【普通静态变量】 和 【引用类型静态常量】是需要额外调用putstatic指令的,是在显示初始化阶段执行。
 *
 * Created by dennis on 2018/7/1.
 */
public class CLPreparation {

    public static int a = 100;  //普通静态变量

    public static final int INT_CONSTANT = 1000;//（原始类型）静态常量

    public static final Integer INTEGER_CONSTANT = Integer.valueOf(10000); //（引用类型）静态常量

}
