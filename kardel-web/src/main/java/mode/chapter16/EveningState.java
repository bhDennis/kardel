package mode.chapter16;

/**
 * Created by dennis on 2018/3/9.
 */
public class EveningState extends State{

    @Override
    void writeProgram(Work work) {

        if(work.getWorkFinished()){
            work.setState(new RestState());
        }else{

            if(work.getHour() < 21){
                System.out.println(work.getHour()+"点钟，加班，比较疲惫");
            }else {
                work.setState(new SleepingState());
                work.execute();
            }
        }
    }
}
