package multi.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 *  p.114 支持关闭操作的web服务器
 *  ExecutorService 扩展了Executor接口，添加了一些用于生命周期管理的方法
 *  shutdown方法：执行平缓的关闭过程，不再接受新的任务，同时等待已经提交的任务执行完成（含那些还未开始执行的任务）
 *  shutdownNow方法：执行粗暴的关闭过程，将尝试取消所有运行中的任务，并且丢弃队列中尚未开始执行的任务
 *  isTerminated：可以调用该方法来轮询ExecutorService是否已经终止
 *  awaitTermination：调用该方法来等待ExecutorService到达终止状态，通常在调用了该方法后会立即执行shutdown，从而产生同步地关闭ExecutorService的效果
 *  @author ahs2
 *
 */
public class LifecycleWebServer {

	private final ExecutorService exec = Executors.newFixedThreadPool(100);
	
	public void start() throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(!exec.isShutdown()){
			try {
				final Socket conn = socket.accept();
				exec.execute(new Runnable(){

					@Override
					public void run() {
						
						//handleRequest(conn);
					}
					
				});
			} catch (RejectedExecutionException e) {
			
				if(!exec.isShutdown()){
					// log("task submission rejected",e);	
				}
			}
		}
	}
	
	public void stop(){
		exec.shutdown();
	}
	
}
