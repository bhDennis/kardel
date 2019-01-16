package multi.chapter8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * p.159  程序清单 8-4
 * 使用Semaphore来控制任务的提交速率  前提：无界队列
 * http://blog.csdn.net/zzy7075/article/details/52095773
 * @author ahs2
 *
 */
public class BoundedExecutorTest {

	private final Executor exec;
	
	private final Semaphore semaphore;
	
	public BoundedExecutorTest(Executor exec,int bound){
		this.exec = exec;
		this.semaphore = new Semaphore(bound);//参数bound表示许可数目，即同时可以允许多少线程进行访问
	}
	
	public void submitTask(final Runnable command) throws InterruptedException{
		semaphore.acquire();//获取一个许可
		try {
			exec.execute(new Runnable(){

				@Override
				public void run() {
					try {
						command.run();
					} catch (Exception e) {
						semaphore.release();//释放一个许可
					}		
				}		
			});
//			exec.execute(command);  不这样写的原因是因为command虽然是一个实现Runnable的线程类，但并没有采用start方法启动
		} catch (RejectedExecutionException e) {
			semaphore.release();
		}
	}
}
