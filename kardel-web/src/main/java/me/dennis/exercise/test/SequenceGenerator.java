package me.dennis.exercise.test;


/**
 * Created by dennis on 2016/12/12.
 */
public class SequenceGenerator {

    private  String prefix;
    private  String suffix;
    private  int initial;
    private  int counter;

    public  SequenceGenerator(){}

    public SequenceGenerator(String prefix, String suffix, int initial) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.initial = initial;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public synchronized  String getSequence(){

        StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        sb.append(initial+counter++);
        sb.append(suffix);

        return sb.toString();
    }
}
