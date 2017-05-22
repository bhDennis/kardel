package chapter5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService 继承Executor，它的目的是为我们管理Thread对象，从而简化并发编程，Executor
 * 使我们无需显示的去管理线程的生命周期，是JDK5之后启动任务的首选方式
 *
 */
public class CallableAndFutureTest1 {

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
		
		Callable<Integer> callable = new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {

				return new Random().nextInt(100);
			}
			
		};
		
		Future<Integer> future = threadPool.submit(callable);
		try {
			Thread.sleep(2000);
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
