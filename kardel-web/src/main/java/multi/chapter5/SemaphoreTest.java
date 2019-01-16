package multi.chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * http://blog.csdn.net/shihuacai/article/details/8856526
 * Semaphore是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制
 * 可以控制同时访问资源的线程个数，例如：实现一个文件允许的并发访问数
 * 下面的示例，虽然有20个线程在执行，但是每次只允许5个并发执行，这是通过Semaphore实现的。
 */
public class SemaphoreTest {

	public static void main(String[] args) {

		//线程池
		ExecutorService executorService = Executors.newCachedThreadPool();

		//只能5个线程同时访问
		final Semaphore semaphore = new Semaphore(5);

		//模拟20个客户端访问
		for(int index = 0;index<20;index++){
			final int indexExt = index;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();	//获取一个许可证，表示可用的许可证数量
						System.out.println("Accessing:"+indexExt);
						Thread.sleep((long) (Math.random()) * 10000);
						semaphore.release();//访问完后，释放，如果屏下面语句，则在控制台只能打印出5条记录，之后线程一直阻塞

					} catch (InterruptedException e) {

					}
				}
			});
		}
		executorService.shutdown();
	}
}
