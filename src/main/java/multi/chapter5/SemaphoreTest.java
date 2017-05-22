package multi.chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * http://blog.csdn.net/shihuacai/article/details/8856526
 * Semaphore是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制
 * 可以控制同时访问资源的线程个数，例如：实现一个文件允许的并发访问数
 * @author ahs2
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {

		//线程池
		ExecutorService exec = Executors.newCachedThreadPool();

		//只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);

		//模拟20个客户端访问
		for(int index = 0;index<20;index++){
			
			final int NO = index;
			Runnable run = new Runnable(){
				@Override
				public void run() {
					
			      try {
					 semp.acquire();
					 System.out.println("Accessing:"+NO);
					 Thread.sleep((long) (Math.random()) * 10000);

					  //访问完后，释放，如果屏下面语句，则在控制台只能打印出5条记录，之后线程一直阻塞
					 semp.release();
				     } catch (InterruptedException e) {}			
				}
			};
//			System.out.println("返回此信号量中当前可用许可数:"+semp.availablePermits());
//			System.out.println("是否有线程正在等待获取:"+semp.hasQueuedThreads());
			exec.execute(run);
		}
		//退出线程池
		exec.shutdown();
	}
}
