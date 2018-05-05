package mode.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class NoonState extends State{

    @Override
    void writeProgram(Work work) {

        if(work.getHour() < 13){
            System.out.println(work.getHour()+"点钟，饿了，犯困");
        }else {
            work.setState(new AfternoonState());
            work.execute();
        }
    }
}
