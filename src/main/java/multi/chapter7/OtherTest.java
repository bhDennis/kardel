package multi.chapter7;

import dto.Task;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class OtherTest {

	//p.132 程序清单 7-7 不可取消的任务在退出前恢复中断
	public Task getNextTask(BlockingQueue<Task> queues){
		
		boolean interrupted = false;
		try {
			while(true){
				try {
					return queues.take();
				} catch (InterruptedException e) {
					interrupted = true;
					//���³���
				}
			}
		} finally {
		    if(interrupted){
		    	Thread.currentThread().interrupt();
		    }
		}		
	}

	//程序7-8 在外部线程中安排中断  为了解决PrimeGenerator中抛出异常而不被主线程捕获的问题
	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(2);
	
	public static void timedRun(Runnable r,long timeout,TimeUnit unit){
		
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable(){

			@Override
			public void run() {
			     taskThread.interrupt();		
			}
			
		}, timeout, unit);
		r.run();
	}

	//程序7-9 在专门的线程中中断任务
	public static void timedRunSpecial(final Runnable r,long timeout,TimeUnit unit) throws Throwable {
		
		class RethrowableTask implements Runnable{

			private volatile Throwable t;//可以确保该异常安全的从其任务线程发布到timeRunSpecial的调用者线程
			
			@Override
			public void run() {
				
				try {
					r.run();
				} catch (Throwable t) {
					this.t = t;
				}
			}	
				
			void rethrow() throws Throwable{
				if(t!=null)
					throw launderThrowable(t);
			}

			private Throwable launderThrowable(Throwable t2) {
				return t2;
			}
		}


		//执行任务的线程
		RethrowableTask task = new RethrowableTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();

		//限时运行
		cancelExec.schedule(new Runnable(){

			@Override
			public void run() {
			    taskThread.interrupt();		
			}
			
		}, timeout, unit);
		
		taskThread.join(unit.toMillis(timeout));
		task.rethrow();
	}
	
	private static final ExecutorService taskExec = Executors.newCachedThreadPool();

	//通过Future来实现取消  程序清单 7-10
	public static void timedRunFuture(Runnable r,long timeout,TimeUnit unit) throws InterruptedException{
		
		Future<?> task = taskExec.submit(r);
		
		try {
			task.get(timeout, unit);
		}  catch (ExecutionException e) {
			// 如果在任务中抛出了异常，那么重新抛出该异常
		} catch (TimeoutException e) {
			// 接下来任务将被取消
		}finally {
			// 如果任务已结束，那么执行取消操作也不会带来影响
			task.cancel(true);//如果任务正在运行中，那么将被中断
		}
	}

	// 通过改写interrupt方法将非标准的取消操作封装在Thread中
	public class ReaderThread extends Thread{
		
		private static final int BUFSZ = 100;
		private final Socket socket;
		private final InputStream in;
		
		public ReaderThread(Socket socket) throws IOException{
			this.socket = socket;
			this.in = socket.getInputStream();
		}
		
		public void interrupt(){
			try {
				socket.close();
			} catch (IOException e) {
			    
			} finally {
				super.interrupt();
			}
		}
		
		public void run(){
			
			try {
				byte[] buf = new byte[BUFSZ];
				while(true){
					int count = in.read(buf);
					if(count < 0){
						break;
					}else if(count > 0){
						//处理逻辑
					}
				}
			} catch (IOException e) {
				//允许线程退出
			}
		}
	}

	//通过 newTaskFor将非标准的取消操作封装在一个任务中  程序 7-12
	public interface CancellableTask<T> extends Callable<T>{
		
		void cancel();
		RunnableFuture<T> newTask();
	}
	
	public class CancellingExecutor extends ThreadPoolExecutor{
		
		public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
		}

		protected<T> RunnableFuture<T> newTaskFor(Callable<T> callable){
			if(callable instanceof CancellableTask){
				return ((CancellableTask<T>) callable).newTask();
			}else{
				return super.newTaskFor(callable);
			}
		}
	}
		
	public abstract class SocketUsingTask<T> implements CancellableTask<T>{
		
		private Socket socket;
		
		protected synchronized void setSocket(Socket s){
			socket = s;
		}
		
		@Override
		public synchronized void cancel(){
			try {
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
                
			}
		}
		
		@Override
		public RunnableFuture<T> newTask(){
			return new FutureTask<T>(this){
				public boolean cancel(boolean mayInterruptIfRunnig){
					try {
						SocketUsingTask.this.cancel();
					} finally {
						return super.cancel(mayInterruptIfRunnig);
					}
				}
			};
		}
	}	
}
