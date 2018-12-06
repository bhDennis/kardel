package me.dennis.course.p34;

/**
 * Created by Dennis on 2018/8/15.
 */
public class Animal {

    private String desc;

    public Animal(){
        System.out.println("Animal 无参构造器"+",this引用:"+this);
        this.desc = getDesc();  // 即 this.getDesc(); 避免在父类构造器中调用被子类重写过的方法
        System.out.println("Animal 无参构造器:"+this.desc);
    }

    public String getDesc() {
        return "Animal";
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
