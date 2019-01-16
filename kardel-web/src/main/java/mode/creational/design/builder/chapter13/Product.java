package mode.creational.design.builder.chapter13;

import java.util.ArrayList;
import java.util.List;

public class Product {

    List<String> parts = new ArrayList<String>();

    public void add(String part){

        parts.add(part);
    }

    public void show(){

       parts.stream().forEach(t->{

           System.out.println("产品部件:"+t);
       });
    }
}
