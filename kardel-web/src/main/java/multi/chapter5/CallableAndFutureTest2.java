package multi.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//http://blog.csdn.net/ghsau/article/details/7451464 ִ执行多个带返回值的任务
public class CallableAndFutureTest2 {

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		
		for(int i=1;i<5;i++){
			final int taskID = i;
			Callable<Integer> callable = new Callable<Integer>(){
				@Override
				public Integer call() throws Exception {					
					return taskID;
				}
				
			};
			cs.submit(callable);
		}
		
		for(int i = 1;i<5;i++){
			try {
				Thread.sleep(2000);
				System.out.println(cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}	
		}
	}
}
