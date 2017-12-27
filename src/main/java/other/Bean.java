package other;
import java.util.List;

public class Bean {

    private String message;

    private List<Integer> holidays;

    private Bean(String message, List<Integer> holidays){
        this.message = message;
        this.holidays = holidays;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void hello() {
        System.out.println("hello," + message);
    }

    public void setHolidays(List<Integer> holidays) {
        this.holidays = holidays;
    }
}
