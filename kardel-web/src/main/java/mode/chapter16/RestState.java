package mode.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class RestState extends State{

    @Override
    void writeProgram(Work work) {

        System.out.println(work.getHour()+"点钟，下班回家休息了");
    }
}
