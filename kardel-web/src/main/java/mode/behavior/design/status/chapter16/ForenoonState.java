package mode.behavior.design.status.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class ForenoonState extends State{

    @Override
    void writeProgram(Work work) {

        if(work.getHour() < 12){
            System.out.println(work.getHour()+"点钟，上午精神百倍，努力工作");
        }else {
            work.setState(new NoonState());
            work.execute();
        }
    }
}
