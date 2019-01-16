package com.spring.exercise.p104;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * Created by dennis on 2018/12/17.
 */
public class CheckoutEvent extends ApplicationEvent{

    private double amount;
    private Date date;

    public CheckoutEvent(Object source,double amount,Date date) {
        super(source);
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
