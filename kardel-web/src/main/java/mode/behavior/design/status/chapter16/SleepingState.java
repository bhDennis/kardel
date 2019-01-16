package mode.behavior.design.status.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class SleepingState extends State{

    @Override
    void writeProgram(Work work) {

        System.out.println(work.getHour()+"点钟，好困，睡着了要");
    }
}
