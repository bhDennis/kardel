package com.spring.exercise.p115;

/**
 * Created by dennis on 2018/12/19.
 */
public class UnitCalculatorImpl implements UnitCalculator {
    @Override
    public double kilogramToPound(double kilogram) {
        double pound = kilogram * 2;
        System.out.print(kilogram+"kilogram="+pound+"pound");
        return 0;
    }

    @Override
    public double kilogramToMile(double kilogram) {
        double mile = kilogram * 0.62;
        System.out.print(kilogram+"kilogram="+mile+"mile");
        return 0;
    }
}
