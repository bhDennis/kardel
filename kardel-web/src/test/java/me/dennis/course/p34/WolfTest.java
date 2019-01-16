package me.dennis.course.p34;

/**
 * Created by Dennis on 2018/8/15.
 */
public class WolfTest{

    public static void main(String[] args){
        System.out.println(new Wolf("灰太狼",32.3).getDesc());
    }
}

class Wolf extends Animal {

    private String name;

    private double weight;

    public Wolf(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getDesc() {
        return "WolfTest[name="+name+",weight="+weight+"]";
    }
}
