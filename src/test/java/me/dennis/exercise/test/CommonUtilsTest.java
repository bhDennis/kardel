package me.dennis.exercise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import other.Bean;
import other.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class CommonUtilsTest {

    @Test
    public void accessibleConstructor() throws NoSuchMethodException {

        List<Integer> s = new ArrayList<Integer>(){{
            add(1);
        }};

//        System.out.println(Bean.class.getConstructor(String.class,List.class)); // 如果将Bean的构造器定义为private，此处会抛出异常 java.lang.NoSuchMethodException: other.Bean.<init>(java.lang.String, java.util.List)

        Constructor<Bean> constructor = CommonUtils.accessibleConstructor(Bean.class,String.class,List.class); // accessibleConstructor作用是使Bean的构造器即使为private也让它变得可用

        System.out.println("constructor:"+constructor);
    }
}
