package mode.behavior.design.status.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class WorkTest {

    public static void main(String[] args){

        Work work = new Work();
        work.setHour(9);
        work.execute();

        work.setHour(12);
        work.execute();

        work.setHour(14);
        work.execute();

        work.setHour(18);
        work.execute();

        work.setHour(22);
        work.execute();
    }
}
