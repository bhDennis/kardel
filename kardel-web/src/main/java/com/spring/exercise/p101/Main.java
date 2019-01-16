package com.spring.exercise.p101;

import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;

/**
 * Created by dennis on 2018/12/17.
 */
public class Main {

    public static void main(String[] args){

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml");

        String alert = applicationContext.getMessage("alert.checkout",new Object[]{4,new Date()}, Locale.US);

        System.out.print(alert);
    }
}
