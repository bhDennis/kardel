package me.dennis.exercise.test;

import me.aihuishou.spring.UserLabel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserLabelTest {

    @Autowired
    private UserLabel userLabel;

    @Test
    public void customLabel(){
        System.out.println("user:"+userLabel);
    }
}
