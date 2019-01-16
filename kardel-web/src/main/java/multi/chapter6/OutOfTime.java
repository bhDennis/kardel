package multi.chapter6;

import java.util.Timer;
import java.util.TimerTask;

//p.116 错误的Timer行为
public class OutOfTime {

	public static void main(String[] args) {
		
		Timer timer = new Timer(); //  Timer是基于绝对时间而不是相对时间的调度机制
		timer.schedule(new ThrowTask() , 1);
		// sleep(1)  
		timer.schedule(new ThrowTask(), 1);
		// sleep(5);
	}
	
	static class ThrowTask extends TimerTask{

		@Override
		public void run() {
			throw new RuntimeException();
			
		}
	   
	}
}
