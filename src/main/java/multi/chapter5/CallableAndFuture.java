package multi.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// http://www.cnblogs.com/whgw/archive/2011/09/28/2194760.html
public class CallableAndFuture {

	public static class MyCallable implements Callable{
	
		private int flag = 0;
		public MyCallable(int flag){
			this.flag = flag;
		}
		
		public String call() throws Exception{
			if(this.flag == 0){
				return "flag == 0";
			}
			if(this.flag == 1){
				try {
					while(true){
						System.out.println("looping.");
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
			       System.out.println("Interrupted");
				}
				return "false";
			}else{
				throw new Exception("Bad flag value");
			}
		}
	}
	
	public static void main(String[] args){
		
		MyCallable task1 = new MyCallable(0);
		MyCallable task2 = new MyCallable(1);
		MyCallable task3 = new MyCallable(2);
		
		//����һ��ִ������ķ���
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		try {
			//提交并执行任务，任务启动时返回了一个Future对象，如果得到任务执行的结果或者是异常可对这个Future对象进行操作
//			Future future1 = es.submit(task1);
//			System.out.println("task1:"+future1.get());
//
//			//获取第三个任务的输出，因为执行第三个任务会引起异常
//			Future future3 = es.submit(task3);
//			System.out.println("task3:"+future3.get());
//
//			//等待5s后再执行第二个任务，因为第二个任务进行的是无限循环
//			Future future2 = es.submit(task2);
//			Thread.sleep(5000);
//			System.out.println("task2:"+future2.get());

			// 方式1：p.118 将任务使用FutureTask包装后提交给ExecutorService来执行
			FutureTask futureTask = new FutureTask(task1);
			Future future4 = es.submit(futureTask);
			System.out.println("future4:"+futureTask.get());

			// 方式2：直接调用FutureTask的run方法来执行
			futureTask.run();
			System.out.println("futureTask:"+futureTask.get());

		} catch (Exception e) {
			System.out.println("异常message:"+e.getMessage());
		}

		//停止任务执行服务
		es.shutdown();
	}
}
