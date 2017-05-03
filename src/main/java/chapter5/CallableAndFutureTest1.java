package chapter5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService �̳�Executor������Ŀ����Ϊ���ǹ���Thread���󣬴Ӷ��򻯲�����̣�Executor
 * ʹ����������ʾ��ȥ�����̵߳��������ڣ���JDK5֮�������������ѡ��ʽ
 * @author ahs2
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
