package multi.chapter7;

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

import me.aihuishou.dto.Task;

public class OtherTest {

	//p.132 �����嵥 7-7 ����ȡ�����������˳�ǰ�ָ��ж�
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
	
	//����7-8 ���ⲿ�߳��а����ж�  Ϊ�˽��PrimeGenerator���׳��쳣���������̲߳��������
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
	
	//����7-9 ��ר�ŵ��߳����ж�����
	public static void timedRunSpecial(final Runnable r,long timeout,TimeUnit unit) throws Throwable {
		
		class RethrowableTask implements Runnable{

			private volatile Throwable t;//����ȷ�����쳣��ȫ�Ĵ��������̷߳�����timeRunSpecial�ĵ������߳�
			
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

			
		//ִ��������߳�
		RethrowableTask task = new RethrowableTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		
		//��ʱ����
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
	
	//ͨ��Future��ʵ��ȡ��  �����嵥 7-10
	public static void timedRunFuture(Runnable r,long timeout,TimeUnit unit) throws InterruptedException{
		
		Future<?> task = taskExec.submit(r);
		
		try {
			task.get(timeout, unit);
		}  catch (ExecutionException e) {
			// ������������׳����쳣����ô�����׳����쳣
		} catch (TimeoutException e) {
			// ���������񽫱�ȡ��
		}finally {
			// ��������ѽ�������ôִ��ȡ������Ҳ�������Ӱ��
			task.cancel(true);//����������������У���ô�����ж�
		}
	}

	// ͨ����дinterrupt�������Ǳ�׼��ȡ��������װ��Thread��
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
						//�����߼�
					}
				}
			} catch (IOException e) {				
				//�����߳��˳�
			}
		}
	}
	
	//ͨ�� newTaskFor���Ǳ�׼��ȡ��������װ��һ��������  ���� 7-12
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
