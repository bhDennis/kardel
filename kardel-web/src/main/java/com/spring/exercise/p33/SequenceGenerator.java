package com.spring.exercise.p33;

/**
 * Created by dennis on 2018/11/27.
 */
public class SequenceGenerator {

    private String prefix;

    private String suffix;

    private int initial;

    private int counter;

    public SequenceGenerator(){

    }
    public SequenceGenerator(String prefix,String suffix,int initial){

        this.prefix = prefix;
        this.suffix = suffix;
        this.initial = initial;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public synchronized String getSequence(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(prefix);
        stringBuffer.append(initial+counter++);
        stringBuffer.append(suffix);
        return stringBuffer.toString();
    }
}
