package me.dennis.course.p135;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 2018/12/12.
 */
public class Apple<T extends Number> {      //泛型类Apple,其类型的形参上限是Number

    T size;
    public Apple(){

    }
    public Apple(T size){
        this.size = size;
    }
    public void setSize(T size){
        this.size = size;
    }
    public T getSize(){
        return this.size;
    }
    public List<String> getApples(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add(new Apple<Integer>(10*i).toString());
        }
        return list;
    }
    public String toString(){
        return "Apple[size="+ size +"]";
    }
}
