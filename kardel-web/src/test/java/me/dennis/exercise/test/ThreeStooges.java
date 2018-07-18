package me.dennis.exercise.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dennis on 2018/7/18.
 */
public final class ThreeStooges {

    private final Set<String> stoogets = new HashSet<>();

    public ThreeStooges(){
        stoogets.add("Moe");
        stoogets.add("Larry");
        stoogets.add("Curly");
    }

    public boolean isStooge(String name){
        return stoogets.contains(name);
    }

    public void set(){
        stoogets.add("HZX");
    }
}
