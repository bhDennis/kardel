package me.dennis.exercise.test;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Dennis on 2018/4/13.
 */
public class TestApplicationContextInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {
    @Override
    public void initialize(XmlWebApplicationContext xmlWebApplicationContext) {

        System.out.println("init TestApplicationContextInitializer");
    }
}
