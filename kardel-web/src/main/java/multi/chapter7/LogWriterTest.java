package multi.chapter7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//p.139 程序7-13 不支持关闭的生产者-消费者日志任务
public class LogWriterTest {

	private final BlockingQueue<String> queue;
	
	private final LoggerThread logger;
	
	public LogWriterTest(Writer writer){
		this.queue = new LinkedBlockingQueue<String>(50);
		this.logger = new LoggerThread((PrintWriter)writer);
	}
	
	public void start(){
		logger.start();
	}
	
	public void log(String msg) throws InterruptedException{
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
				   writer.println(queue.take());
			   }
			} catch (InterruptedException e) {
			   //不处理
			}finally {
				writer.close();
			}
		}
	}
}
