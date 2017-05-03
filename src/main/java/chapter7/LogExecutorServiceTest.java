package chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// 7-16 p.140
public class LogExecutorServiceTest {

	private static final int TIMEOUT = 60;
	private final ExecutorService exec = Executors.newSingleThreadExecutor();
	
	public void start(){
		this.log("msg");
	}
	
	public void stop(){
	
		try {
			exec.shutdown();
			exec.awaitTermination(TIMEOUT, TimeUnit.MICROSECONDS);
		} catch (InterruptedException e) {}
	}
	
	public void log(String msg){
		try {
			exec.execute(new WriteTask(msg));
		} catch (RejectedExecutionException ignored) {
		
		}
	}
	
	private class WriteTask extends Thread{
		
		private String msg;				
		private WriteTask(String msag){
			this.msg = msg;
		}
		
		@Override
		public void run() {
	       System.out.println(msg);
		}
	}
	
}
