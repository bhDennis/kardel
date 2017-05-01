package me.dennis.exercise;


import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dennis on 2016/12/11.
 */
public class Main {

    public static void main(String[] args) throws BeansException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = (HelloWorld) context.getBean(HelloWorld.class);

        helloWorld.hello();
    }
}