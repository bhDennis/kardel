package me.dennis.exercise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class HelloWorldTest {

    @Test
    public void hello(){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = context.getBean(HelloWorld.class);

        helloWorld.hello();
    }
}
