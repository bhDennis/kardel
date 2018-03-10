package mode.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class AfternoonState extends State{

    @Override
    void writeProgram(Work work) {

        if(work.getHour() < 17){

            System.out.println(work.getHour()+"点钟，下午状态还不错");
        }else {
            work.setState(new EveningState());
            work.execute();
        }
    }
}
