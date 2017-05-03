package chapter7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


// p.140 ����7-15 ��LogWriter��ӿɿ���ȡ������
public class LogServiceTest {

	private final BlockingQueue<String> queue;

	private final LoggerThread loggerThread;
	
	private boolean isShutdown;
	
	private int reservations;
	
	public LogServiceTest(Writer writer){
		this.queue = new LinkedBlockingQueue<String>(50);
		this.loggerThread = new LoggerThread((PrintWriter)writer);
	}
	public void start(){
		loggerThread.start();
	}
	public void stop(){
		synchronized(this){
			isShutdown = true;
			loggerThread.interrupt();
		}
	}
	
	public void log(String msg) throws InterruptedException{
		synchronized(this){
			if(isShutdown){
				throw new IllegalStateException("e");
			}
			++ reservations;  //����һ���������������ύ��Ϣ��Ȩ��
		}
		queue.put(msg);
	}
	
	private class LoggerThread extends Thread{
		
		private final PrintWriter writer;
		
		private LoggerThread(PrintWriter writer){
			this.writer = writer;
		}
		
		@Override
		public void run() {
			
			try {
				while(true){
					try {
						synchronized(LogServiceTest.this){
							if(isShutdown && reservations == 0){
								break;
							}
						}
						String msg = queue.take();
						synchronized(LogServiceTest.this){
							--reservations;
						}
						writer.println(msg);					
					} catch (InterruptedException e) {
				         /* retry */
					}
				}
			}finally {
				writer.close();
			}
		}
	}
}
