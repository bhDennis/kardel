package com.spring.exercise.p91;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dennis on 2018/12/17.
 */
public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public void addItem(Product item){
        products.add(item);
    }

    public List<Product> getItems(){
        return products;
    }
}
