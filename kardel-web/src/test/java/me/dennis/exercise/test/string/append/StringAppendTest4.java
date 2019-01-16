package me.dennis.exercise.test.string.append;

import mode.creational.design.factory.abstrac.chapter15.model.User;

/**
 * Created by Dennis on 2018/11/13.
 */
public class StringAppendTest4 {

    public static void main(String[] args){

        User user = User.builder()
                .name("hzx")
                .age(20)
                .build();

        String a = "a" + user;
        System.out.println(a);
    }
}
