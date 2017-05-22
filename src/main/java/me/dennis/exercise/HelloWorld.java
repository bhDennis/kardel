package me.dennis.exercise;

import me.dennis.exercise.dto.Holiday;
import java.util.List;

/**
 * Created by dennis on 2016/12/11.
 */
public class HelloWorld {

    private String message;

    private List<Holiday> holidays;

    public void setMessage(String message) {
        this.message = message;
    }

    public void hello() {
        System.out.println("hello," + message);
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }
}
