package com.spring.exercise.p109;

import com.spring.exercise.p91.Product;

import java.beans.PropertyEditorSupport;

/**
 * Created by dennis on 2018/12/17.
 */
public class ProductEditor  extends PropertyEditorSupport{

    // 将属性转换为字符串值
    public String getAsText(){

        Product product = (Product)getValue();
        return product.getClass().getName() +"," +product.getName() +"," +product.getPrice();
    }

    // 将字符串转换为属性
    public void setAsText(String text){

        try {
            String[] parts = text.split(",");
            Product product = (Product)Class.forName(parts[0]).newInstance();
            product.setName(parts[1]);
            product.setPrice(Double.parseDouble(parts[2]));

        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
