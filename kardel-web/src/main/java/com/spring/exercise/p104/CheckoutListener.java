package com.spring.exercise.p104;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * Created by dennis on 2018/12/17.
 */
public class CheckoutListener implements ApplicationListener{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof CheckoutEvent){

            double amount = ((CheckoutEvent) event).getAmount();
            Date date = ((CheckoutEvent) event).getDate();

            System.out.print("--向用户发送邮件---");
        }
    }
}
