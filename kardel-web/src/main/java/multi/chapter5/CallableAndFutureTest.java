package multi.chapter5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTest {

	public static void main(String[] args) {
		
		Callable<Integer> callable = new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {

				return new Random().nextInt(100);
			}
			
		};
		
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();// FutureTask作为Runnable被线程执行
		
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
