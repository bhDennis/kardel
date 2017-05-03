package multi.chapter6;

import java.util.Timer;
import java.util.TimerTask;

//p.116 �����Timer��Ϊ
public class OutOfTime {

	public static void main(String[] args) {
		
		Timer timer = new Timer(); // Timer�ǻ��ھ���ʱ����������ʱ��ĵ��Ȼ���
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
