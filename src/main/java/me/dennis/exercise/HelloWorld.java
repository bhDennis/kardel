package me.dennis.exercise;

/**
 * Created by dennis on 2016/12/11.
 */
public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void hello() {
        System.out.println("hello," + message);
    }
}
