package me.dennis.exercise.test.string.append;

import mode.creational.design.factory.abstrac.chapter15.model.User;

/**
 * Created by Dennis on 2018/11/13.
 */
public class StringAppendTest5 {

    public static void main(String[] args){

        User user = User.builder()
                .name("hzx")
                .age(20)
                .build();

        System.out.println(user);
    }
}
