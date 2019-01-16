package me.dennis.exercise.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dennis on 2016/12/12.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

    private int month;
    private int day;
    private String greeting;
}
